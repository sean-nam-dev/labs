package dev.sn.littlelemoncoursera.presentation.uiAction

sealed class HomeUiAction {
    data class NavigateToDetail(val index: Int): HomeUiAction()
}