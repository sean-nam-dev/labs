package dev.sn.littlelemondata.data.source.remote

import dev.sn.littlelemondata.data.model.MenuItemDto
import dev.sn.littlelemondata.data.model.MenuDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class Api(
    private val httpClient: HttpClient
) {

    suspend fun get(): List<MenuItemDto> {
        val response: MenuDto = httpClient.get(URL).body()
        return response.menu
    }

    companion object {
        private const val URL = "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/littleLemonSimpleMenu.json"
    }
}