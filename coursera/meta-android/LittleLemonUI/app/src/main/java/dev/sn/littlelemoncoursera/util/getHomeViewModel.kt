package dev.sn.littlelemoncoursera.util

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import dev.sn.littlelemoncoursera.data.DishRepositoryImpl
import dev.sn.littlelemoncoursera.navigation.Navigator
import dev.sn.littlelemoncoursera.presentation.viewmodel.HomeViewModel

@Composable
fun getHomeViewModel(
    navBackStackEntry: NavBackStackEntry?,
    navigator: Navigator
): HomeViewModel {
    return if (navBackStackEntry == null) {
        viewModel(
            factory = HomeViewModel.Factory,
            extras = MutableCreationExtras().apply {
                set(
                    HomeViewModel.NAVIGATOR_KEY,
                    navigator
                )
                set(
                    HomeViewModel.DISH_REPOSITORY_KEY,
                    DishRepositoryImpl
                )
            }
        )
    } else {
        viewModel(
            viewModelStoreOwner = navBackStackEntry,
            factory = HomeViewModel.Factory,
            extras = MutableCreationExtras().apply {
                set(
                    HomeViewModel.NAVIGATOR_KEY,
                    navigator
                )
                set(
                    HomeViewModel.DISH_REPOSITORY_KEY,
                    DishRepositoryImpl
                )
            }
        )
    }
}