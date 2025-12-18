package dev.sn.littlelemondata.data.repository

import dev.sn.littlelemondata.data.converter.toDomain
import dev.sn.littlelemondata.data.converter.toEntity
import dev.sn.littlelemondata.data.model.MenuItemDto
import dev.sn.littlelemondata.data.source.local.MenuDao
import dev.sn.littlelemondata.data.source.local.MenuItemEntity
import dev.sn.littlelemondata.data.source.remote.Api
import dev.sn.littlelemondata.domain.model.MenuItem
import dev.sn.littlelemondata.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MenuRepositoryImpl(
    private val api: Api,
    private val dao: MenuDao
) : MenuRepository {

    override suspend fun observeMenu(context: CoroutineContext): Flow<List<MenuItem>> {
        return withContext(context) {
            dao.observe().map {
                it.map(MenuItemEntity::toDomain)
            }
        }
    }

    override suspend fun refresh(context: CoroutineContext) {
        withContext(context) {
            val list = api.get().map(MenuItemDto::toDomain)
            dao.insert(list.map(MenuItem::toEntity))
        }
    }
}