package dev.sn.littlelemondata.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MenuDto(
    val menu: List<MenuItemDto>
)
