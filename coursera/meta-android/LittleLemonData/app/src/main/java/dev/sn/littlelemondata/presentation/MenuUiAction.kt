package dev.sn.littlelemondata.presentation

sealed class MenuUiAction {

    data object OnClearAction : MenuUiAction()

    data class OnQueryAction(val text: String) : MenuUiAction()

    data object OnSortAction : MenuUiAction()
}