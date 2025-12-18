package dev.sn.littlelemondata.domain.repository

import dev.sn.littlelemondata.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

interface MenuRepository {

    suspend fun observeMenu(context: CoroutineContext): Flow<List<MenuItem>>

    suspend fun refresh(context: CoroutineContext)
}