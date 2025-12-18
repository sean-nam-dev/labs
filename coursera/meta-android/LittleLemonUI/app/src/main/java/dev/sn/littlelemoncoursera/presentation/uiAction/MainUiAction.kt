package dev.sn.littlelemoncoursera.presentation.uiAction

import dev.sn.littlelemoncoursera.util.Filter
import dev.sn.littlelemoncoursera.util.Sort

sealed class MainUiAction {

    data class OnSort(val sort: Sort) : MainUiAction()

    data class OnFilter(val filter: Filter) : MainUiAction()
}