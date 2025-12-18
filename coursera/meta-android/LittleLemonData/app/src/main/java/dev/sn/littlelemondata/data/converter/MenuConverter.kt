package dev.sn.littlelemondata.data.converter

import dev.sn.littlelemondata.data.model.MenuDto
import dev.sn.littlelemondata.domain.model.Menu

fun MenuDto.toDomain() = Menu(
    menuItems = this.menu.map { it.toDomain() }
)

fun Menu.toData() = MenuDto(
    menu = this.menuItems.map { it.toData() }
)