package dev.sn.littlelemondata.data.source.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuDao {

    @Query("SELECT * FROM menu_items")
    fun observe(): Flow<List<MenuItemEntity>>

    @Upsert
    fun insert(items: List<MenuItemEntity>)
}