package dev.sn.littlelemoncoursera.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.sn.littlelemoncoursera.R

@Composable
fun UpperPanel() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colorScheme.secondary)
            .padding(horizontal = 12.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.little_lemon),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.chicago),
            style = MaterialTheme.typography
                .titleSmall
                .copy(
                    color = MaterialTheme.colorScheme
                        .tertiary
                        .copy(alpha = 0.7f)
                )
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.we_are_a_family),
                style = MaterialTheme.typography
                    .bodyMedium
                    .copy(
                        color = MaterialTheme.colorScheme
                            .tertiary
                            .copy(alpha = 0.8f)
                    )
            )
            Image(
                modifier = Modifier.size(175.dp)
                    .clip(RoundedCornerShape(10)),
                painter = painterResource(R.drawable.upperpanelimage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
        Button(
            onClick = {},
            shape = RoundedCornerShape(15),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = stringResource(R.string.order_take_away),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}