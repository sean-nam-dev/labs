package dev.sn.littlelemoncoursera.navigation

import androidx.navigation.NavOptionsBuilder
import dev.sn.littlelemoncoursera.domain.BottomTab

sealed interface NavigationAction {

    data class Navigate(
        val destination: Destination,
        val navOptions: NavOptionsBuilder.() -> Unit = {}
    ): NavigationAction

    data object NavigateUp: NavigationAction
}

fun BottomTab.toDestination(): Destination {
    return when (this) {
        BottomTab.Home -> Destination.HomeScreen
        BottomTab.DinnerMenu -> Destination.DinnerMenuScreen
    }
}