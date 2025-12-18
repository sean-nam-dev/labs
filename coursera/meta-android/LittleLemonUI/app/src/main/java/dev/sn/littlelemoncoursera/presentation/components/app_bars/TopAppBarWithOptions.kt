package dev.sn.littlelemoncoursera.presentation.components.app_bars

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import dev.sn.littlelemoncoursera.R
import dev.sn.littlelemoncoursera.util.Filter
import dev.sn.littlelemoncoursera.util.Sort

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithOptions(
    onSortAction: (Sort) -> Unit,
    onFilterAction: (Filter) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val sortTypePair = listOf(
        stringResource(R.string.a_z) to Sort.AZ,
        stringResource(R.string.price_ascending) to Sort.PriceAscending,
        stringResource(R.string.price_descending) to Sort.PriceDescending
    )
    val filterTypePair = listOf(
        stringResource(R.string.all) to Filter.All,
        stringResource(R.string.drinks) to Filter.Drinks,
        stringResource(R.string.food) to Filter.Food,
        stringResource(R.string.dessert) to Filter.Dessert,
    )

    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.little_lemon_menu),
                fontSize = 25.sp
            )
        },
        actions = {
            Box(modifier = Modifier) {
                IconButton(
                    onClick = { expanded = !expanded }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.MoreVert,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    sortTypePair.forEach { (text, type) ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "${stringResource(R.string.sort)}: $text"
                                )
                            },
                            onClick = {
                                expanded = false
                                onSortAction(type)
                            }
                        )
                    }

                    HorizontalDivider()

                    filterTypePair.forEach { (text, type) ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "${stringResource(R.string.filter)}: $text"
                                )
                            },
                            onClick = {
                                expanded = false
                                onFilterAction(type)
                            }
                        )
                    }
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    )
}