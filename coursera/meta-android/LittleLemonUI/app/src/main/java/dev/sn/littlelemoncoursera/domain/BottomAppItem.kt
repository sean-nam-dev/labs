package dev.sn.littlelemoncoursera.domain

data class BottomAppItem (
    val route: BottomTab,
    val iconRes: Int
)

sealed interface BottomTab {
    object Home : BottomTab
    object DinnerMenu : BottomTab
}
