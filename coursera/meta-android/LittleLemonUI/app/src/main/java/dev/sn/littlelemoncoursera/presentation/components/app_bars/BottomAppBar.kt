package dev.sn.littlelemoncoursera.presentation.components.app_bars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import dev.sn.littlelemoncoursera.navigation.Navigator
import dev.sn.littlelemoncoursera.navigation.toDestination
import dev.sn.littlelemoncoursera.util.ItemManager
import kotlinx.coroutines.launch

@Composable
fun BottomAppBar(
    navigator: Navigator
) {
    val scope = rememberCoroutineScope()

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ItemManager.bottom.forEach { barItem ->
                IconButton(
                    onClick = {
                        scope.launch {
                            navigator.navigate(barItem.route.toDestination())
                        }
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = ImageVector.vectorResource(barItem.iconRes),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}