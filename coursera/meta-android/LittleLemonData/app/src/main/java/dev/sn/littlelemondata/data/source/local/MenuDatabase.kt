package dev.sn.littlelemondata.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MenuItemEntity::class], version = 1)
abstract class MenuDatabase : RoomDatabase() {
    abstract fun menuDao(): MenuDao
}