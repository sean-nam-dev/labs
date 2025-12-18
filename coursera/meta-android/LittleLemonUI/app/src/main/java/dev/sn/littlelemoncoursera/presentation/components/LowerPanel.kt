package dev.sn.littlelemoncoursera.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.sn.littlelemoncoursera.domain.Dish

@Composable
fun LowerPanel(
    isLoading: Boolean,
    dishList: List<Dish>,
    onMenuDishAction: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(5.dp)
    ) {
        if (isLoading) {
            item {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        } else {
            itemsIndexed(dishList) { index, dish ->
                MenuDish(
                    dish = dish,
                    onClick = {
                        onMenuDishAction(index)
                    }
                )
            }
        }
    }
}