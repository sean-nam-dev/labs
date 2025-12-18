package dev.sn.littlelemoncoursera.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.sn.littlelemoncoursera.navigation.Destination
import dev.sn.littlelemoncoursera.navigation.Navigator
import dev.sn.littlelemoncoursera.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun DinnerMenuScreen(
     mainViewModel: MainViewModel,
     navigator: Navigator
) {
    val state = mainViewModel.state.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        itemsIndexed(
            items = state.value.productList,
            key = { _, item -> item.title }
        ) { index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.clickable {
                        scope.launch {
                            navigator.navigate(Destination.DinnerMenuDetailScreen(index))
                        }
                    },
                    painter = painterResource(item.image),
                    contentDescription = null
                )
                Text(
                    item.title,
                    fontSize = 17.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}