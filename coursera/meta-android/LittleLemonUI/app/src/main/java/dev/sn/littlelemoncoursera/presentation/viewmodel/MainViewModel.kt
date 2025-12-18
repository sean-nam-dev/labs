package dev.sn.littlelemoncoursera.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.sn.littlelemoncoursera.domain.Product
import dev.sn.littlelemoncoursera.presentation.uiAction.MainUiAction
import dev.sn.littlelemoncoursera.presentation.uiState.MainUiState
import dev.sn.littlelemoncoursera.util.Filter
import dev.sn.littlelemoncoursera.util.Sort
import dev.sn.littlelemoncoursera.util.Temp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(MainUiState())
    val state = _state.onStart {
        _state.update {
            it.copy(
                productList = sort(
                    it.sort, filter(
                        it.filter, Temp.getProducts()
                    )
                )
            )
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        MainUiState()
    )

    fun onMainUiAction(action: MainUiAction) {
        when (action) {
            is MainUiAction.OnSort -> {
                _state.update {
                    it.copy(
                        sort = action.sort
                    )
                }
            }
            is MainUiAction.OnFilter -> {
                _state.update {
                    it.copy(
                        filter = action.filter
                    )
                }
            }
        }

        _state.update {
            it.copy(
                productList = sort(
                    it.sort, filter(
                        it.filter, Temp.getProducts()
                    )
                )
            )
        }
    }


    private fun sort(
        type: Sort,
        list: List<Product>
    ): List<Product> = when (type) {
            Sort.AZ -> list.sortedBy { it.title }
            Sort.PriceAscending -> list.sortedBy { it.price }
            Sort.PriceDescending -> list.sortedByDescending { it.price }
    }

    private fun filter(
        type: Filter,
        list: List<Product>
    ): List<Product> = when (type) {
        Filter.All -> list
        Filter.Dessert -> list.filter { it.category == "Dessert" }
        Filter.Drinks -> list.filter { it.category == "Drinks" }
        Filter.Food -> list.filter { it.category == "Food" }
    }
}