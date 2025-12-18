package dev.sn.littlelemondata.data.converter

import dev.sn.littlelemondata.data.model.MenuItemDto
import dev.sn.littlelemondata.data.source.local.MenuItemEntity
import dev.sn.littlelemondata.domain.model.MenuItem

fun MenuItemDto.toDomain() = MenuItem(
    id = this.id,
    title = this.title,
    price = this.price
)

fun MenuItem.toData() = MenuItemDto(
    id = this.id,
    title = this.title,
    price = this.price
)

fun MenuItemEntity.toDomain() = MenuItem(
    id = this.id,
    title = this.title,
    price = this.price
)

fun MenuItem.toEntity() = MenuItemEntity(
    id = this.id,
    title = this.title,
    price = this.price
)