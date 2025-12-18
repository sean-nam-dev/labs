package dev.sn.littlelemoncoursera.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.sn.littlelemoncoursera.R
import dev.sn.littlelemoncoursera.presentation.viewmodel.HomeViewModel

@Composable
fun DetailScreen(
    viewModel: HomeViewModel,
    index: Int
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val dish = state.value.dishList[index]

    var counter by remember { mutableIntStateOf(1) }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Image(
                modifier = Modifier.fillMaxWidth()
                    .height(300.dp),
                painter = painterResource(dish.imageResource),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        item {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = dish.name,
                style = MaterialTheme.typography.titleMedium
            )
        }
        item {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = dish.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        item {
            Row(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        if (counter > 1) counter--
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_round_subtract_24),
                        contentDescription = null
                    )
                }
                Text(
                    text = counter.toString(),
                    style = MaterialTheme.typography.labelLarge
                )
                IconButton(
                    onClick = {
                        counter++
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_round_add_24),
                        contentDescription = null
                    )
                }
            }
        }
        item {
            Button(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 10.dp),
                onClick = {},
                shape = RoundedCornerShape(15),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "Add for $${counter * dish.price}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}