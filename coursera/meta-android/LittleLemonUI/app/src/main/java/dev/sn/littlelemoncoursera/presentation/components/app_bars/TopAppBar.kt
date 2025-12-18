package dev.sn.littlelemoncoursera.presentation.components.app_bars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.sn.littlelemoncoursera.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(45.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.littlelemonimgtxt_nobg),
                    contentDescription = null
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Rounded.ShoppingCart,
                    contentDescription = null
                )
            }
        }
    )
}