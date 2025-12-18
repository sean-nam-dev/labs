package dev.sn.littlelemoncoursera.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.sn.littlelemoncoursera.domain.DishRepository
import dev.sn.littlelemoncoursera.navigation.Destination
import dev.sn.littlelemoncoursera.navigation.Navigator
import dev.sn.littlelemoncoursera.presentation.uiAction.HomeUiAction
import dev.sn.littlelemoncoursera.presentation.uiState.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val navigator: Navigator,
    private val dishRepository: DishRepository
): ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.onStart { loadList() }
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            HomeUiState()
        )

    fun onHomeUiAction(action: HomeUiAction) {
        when (action) {
            is HomeUiAction.NavigateToDetail -> {
                viewModelScope.launch {
                    navigator.navigate(Destination.DetailScreen(action.index))
                }
            }
        }
    }

    private fun loadList() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            val dishList = dishRepository.getDishList()

            _state.update {
                it.copy(
                    isLoading = false,
                    dishList = dishList
                )
            }
        }
    }

    companion object {
        val NAVIGATOR_KEY = object : CreationExtras.Key<Navigator> {}
        val DISH_REPOSITORY_KEY = object : CreationExtras.Key<DishRepository> {}
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val navigator = this[NAVIGATOR_KEY] as Navigator
                val dishRepository = this[DISH_REPOSITORY_KEY] as DishRepository

                HomeViewModel(
                    navigator = navigator,
                    dishRepository = dishRepository
                )
            }
        }
    }
}