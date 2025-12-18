package dev.sn.littlelemondata.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MenuItemDto(
    val id: Int,
    val title: String,
    val price: String
)
