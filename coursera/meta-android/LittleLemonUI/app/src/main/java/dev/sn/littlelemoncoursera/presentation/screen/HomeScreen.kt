package dev.sn.littlelemoncoursera.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.sn.littlelemoncoursera.presentation.components.HeaderText
import dev.sn.littlelemoncoursera.presentation.components.LowerPanel
import dev.sn.littlelemoncoursera.presentation.components.UpperPanel
import dev.sn.littlelemoncoursera.presentation.uiAction.HomeUiAction
import dev.sn.littlelemoncoursera.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        UpperPanel()
        HeaderText()
        LowerPanel(
            isLoading = state.value.isLoading,
            dishList = state.value.dishList,
            onMenuDishAction = { id ->
                viewModel.onHomeUiAction(HomeUiAction.NavigateToDetail(id))
            }
        )
    }
}