package dev.sn.littlelemoncoursera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import dev.sn.littlelemoncoursera.navigation.DefaultNavigator
import dev.sn.littlelemoncoursera.navigation.Destination
import dev.sn.littlelemoncoursera.navigation.NavigationAction
import dev.sn.littlelemoncoursera.presentation.NavHostFrame
import dev.sn.littlelemoncoursera.presentation.components.app_bars.TopAppBarWithOptions
import dev.sn.littlelemoncoursera.presentation.uiAction.MainUiAction
import dev.sn.littlelemoncoursera.presentation.viewmodel.MainViewModel
import dev.sn.littlelemoncoursera.ui.theme.LittleLemonCourseraTheme
import dev.sn.littlelemoncoursera.util.ObserveAsEvents

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            val navigator = remember { DefaultNavigator(Destination.DinnerMenuGraph) }

            val mainViewModel: MainViewModel = viewModel()

            ObserveAsEvents(
                navigator.navigationActions
            ) { action ->
                when (action) {
                    is NavigationAction.Navigate -> {
                        navHostController.navigate(route = action.destination) {
                            action.navOptions(this)
                        }
                    }
                    is NavigationAction.NavigateUp -> {
                        navHostController.navigateUp()
                    }
                }
            }

            LittleLemonCourseraTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBarWithOptions(
                            onSortAction = { sortType ->
                                mainViewModel.onMainUiAction(
                                    MainUiAction.OnSort(sortType)
                                )
                            },
                            onFilterAction = { filterType ->
                                mainViewModel.onMainUiAction(
                                    MainUiAction.OnFilter(filterType)
                                )
                            }
                        )
//                        TopAppBar()
                    },
                    bottomBar = {
//                        BottomAppBar(
//                            navigator = navigator
//                        )
                    },
                    content = { paddingValues ->
                        NavHostFrame(
                            modifier = Modifier.padding(paddingValues),
                            navHostController = navHostController,
                            navigator = navigator,
                            mainViewModel = mainViewModel
                        )
                    }
                )
            }
        }
    }
}