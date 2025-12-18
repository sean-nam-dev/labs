package dev.sn.littlelemondata.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.sn.littlelemondata.domain.model.MenuItem
import dev.sn.littlelemondata.domain.repository.MenuRepository
import dev.sn.littlelemondata.util.SortType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class MenuViewModel(
    repository: MenuRepository
) : ViewModel() {
    private val _state = MutableStateFlow(MenuUiState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = MenuUiState()
    )

    private val _items = MutableStateFlow<List<MenuItem>>(emptyList())

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private val _sortType = MutableStateFlow<SortType>(SortType.Name)
    val sortType: StateFlow<SortType> = _sortType

    val itemsOrganized: StateFlow<List<MenuItem>> =
        combine(
            _items,
            _query.debounce(300).map {
                it.trim()
            }.distinctUntilChanged(),
            _sortType
        ) { list, q, s ->
            val result = if (q.isBlank()) {
                list
            } else {
                list.filter { it.title.contains(q, ignoreCase = true) }
            }

            when (_sortType.value) {
                SortType.Name -> result.sortedBy { it.title }
                SortType.Price -> result.sortedByDescending { it.price.toInt() }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun onMenuUiAction(action: MenuUiAction) {
        when (action) {
            is MenuUiAction.OnClearAction -> {
                _query.update { "" }
            }
            is MenuUiAction.OnQueryAction -> {
                _query.value = action.text
            }
            is MenuUiAction.OnSortAction -> {
                when (_sortType.value) {
                    SortType.Name -> _sortType.update { SortType.Price }
                    SortType.Price -> _sortType.update { SortType.Name }
                }
            }
        }
    }

    init {
        viewModelScope.launch {
            repository.refresh(Dispatchers.IO)

            _state.update { it.copy(isLoading = false) }

            repository.observeMenu(Dispatchers.IO).collect { list ->
                _items.value = list
            }
        }
    }

    companion object {
        val REPOSITORY_KEY = object : CreationExtras.Key<MenuRepository> {}

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repository = this[REPOSITORY_KEY] as MenuRepository

                MenuViewModel(
                    repository = repository
                )
            }
        }
    }
}