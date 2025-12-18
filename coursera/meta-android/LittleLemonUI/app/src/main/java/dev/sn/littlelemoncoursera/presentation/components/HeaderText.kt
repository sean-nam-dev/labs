package dev.sn.littlelemoncoursera.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.sn.littlelemoncoursera.R

@Composable
fun HeaderText() {
    Text(
        modifier = Modifier.padding(
            start = 5.dp,
            top = 13.dp,
            end = 5.dp,
            bottom = 15.dp
        ),
        text = stringResource(R.string.weekly_special),
        style = MaterialTheme.typography.titleMedium
    )
}