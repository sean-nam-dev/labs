package dev.sn.littlelemoncoursera.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.sn.littlelemoncoursera.domain.Dish
import dev.sn.littlelemoncoursera.ui.theme.Gray
import dev.sn.littlelemoncoursera.ui.theme.LittleLemonCourseraTheme
import dev.sn.littlelemoncoursera.util.Temp

@Composable
fun MenuDish(
    dish: Dish,
    onClick: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth()
                .height(115.dp)
                .clip(RoundedCornerShape(10))
                .clickable(onClick = onClick),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
                    .height(115.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography
                        .labelLarge
                        .copy(
                            color = Gray
                        )
                )
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "$${dish.price}",
                    style = MaterialTheme.typography
                        .bodyMedium
                        .copy(fontWeight = FontWeight.Bold)
                )
            }
            Image(
                modifier = Modifier.size(115.dp)
                    .clip(RoundedCornerShape(10)),
                painter = painterResource(dish.imageResource),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 10.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
private fun MenuDishPreview() {
    LittleLemonCourseraTheme {
        LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)) {
            items(Temp.getDishes()) {
                MenuDish(it) {}
            }
        }
    }
}