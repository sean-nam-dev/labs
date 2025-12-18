package dev.sn.littlelemoncoursera.util

import dev.sn.littlelemoncoursera.R
import dev.sn.littlelemoncoursera.domain.BottomAppItem
import dev.sn.littlelemoncoursera.domain.BottomTab

object ItemManager {
    val bottom = listOf(
        BottomAppItem(
            route = BottomTab.Home,
            iconRes = R.drawable.ic_filled_home_24
        ),
        BottomAppItem(
            route = BottomTab.DinnerMenu,
            iconRes = R.drawable.ic_filled_dinner_menu_24
        )
    )
}