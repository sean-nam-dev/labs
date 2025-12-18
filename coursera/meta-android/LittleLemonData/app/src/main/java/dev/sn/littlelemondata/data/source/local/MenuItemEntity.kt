package dev.sn.littlelemondata.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menu_items")
data class MenuItemEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val price: String
)
