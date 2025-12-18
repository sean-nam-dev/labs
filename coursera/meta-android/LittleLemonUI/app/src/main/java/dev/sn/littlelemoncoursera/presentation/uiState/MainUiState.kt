package dev.sn.littlelemoncoursera.presentation.uiState

import dev.sn.littlelemoncoursera.domain.Product
import dev.sn.littlelemoncoursera.util.Filter
import dev.sn.littlelemoncoursera.util.Sort
import dev.sn.littlelemoncoursera.util.Temp

data class MainUiState(
    val sort: Sort = Sort.AZ,
    val filter: Filter = Filter.All,
    val productList: List<Product> = Temp.getProducts()
)