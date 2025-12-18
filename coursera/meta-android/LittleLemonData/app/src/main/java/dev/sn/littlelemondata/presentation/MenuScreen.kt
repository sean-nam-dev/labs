package dev.sn.littlelemondata.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.sn.littlelemondata.R
import dev.sn.littlelemondata.util.SortType

@Composable
fun MenuScreen(
    viewModel: MenuViewModel,
    paddingValues: PaddingValues
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val items = viewModel.itemsOrganized.collectAsStateWithLifecycle()
    val query = viewModel.query.collectAsStateWithLifecycle()
    val sortType = viewModel.sortType.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.littlelemonimgtxt_nobg),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
                .padding(35.dp)
        )
        Button(
            onClick = {
                viewModel.onMenuUiAction(MenuUiAction.OnSortAction)
            },
            shape = RoundedCornerShape(10),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFf4ce14),
                contentColor = Color(0xFF5f562c)
            )
        ) {
            Text(
                text = stringResource(R.string.tap_to_order) + when (sortType.value) {
                    SortType.Name -> " ${stringResource(R.string.price)}"
                    SortType.Price -> " ${stringResource(R.string.name)}"
                }
            )
        }
        OutlinedTextField(
            value = query.value,
            onValueChange = {
                viewModel.onMenuUiAction(MenuUiAction.OnQueryAction(it))
            },
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 50.dp),
            trailingIcon = {
                IconButton(
                    onClick = {
                        viewModel.onMenuUiAction(MenuUiAction.OnClearAction)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        contentDescription = null
                    )
                }
            },
            singleLine = true
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            if (state.value.isLoading) {
                item {
                    CircularProgressIndicator()
                }
            } else {
                items(
                    items = items.value,
                    key = { it.id }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = it.title,
                            modifier = Modifier.weight(1f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = it.price
                        )
                    }
                }
            }
        }
    }
}