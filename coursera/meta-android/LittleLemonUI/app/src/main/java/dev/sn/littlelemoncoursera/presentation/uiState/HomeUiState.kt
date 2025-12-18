package dev.sn.littlelemoncoursera.presentation.uiState

import dev.sn.littlelemoncoursera.domain.Dish

data class HomeUiState(
    val isLoading: Boolean = false,
    val dishList: List<Dish> = emptyList()
)