package dev.sn.littlelemoncoursera.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.sn.littlelemoncoursera.presentation.viewmodel.MainViewModel

@Composable
fun DinnerMenuDetailScreen(
    index: Int,
    viewModel: MainViewModel
) {
    val currentProduct = viewModel.state.value.productList[index]

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(currentProduct.image),
            contentDescription = null
        )
        Text(currentProduct.title)
        Text("Price $${currentProduct.price}")
        Text("Category: ${currentProduct.category}")
    }
}