package dev.sn.littlelemondata

import android.app.Application
import androidx.room.Room
import dev.sn.littlelemondata.data.repository.MenuRepositoryImpl
import dev.sn.littlelemondata.data.source.local.MenuDatabase
import dev.sn.littlelemondata.data.source.remote.Api
import dev.sn.littlelemondata.domain.repository.MenuRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class App : Application() {

    lateinit var menuRepository: MenuRepository
        private set

    override fun onCreate() {
        super.onCreate()

        val httpClient = HttpClient(Android) {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                    },
                    contentType = ContentType.Text.Plain
                )
            }
        }
        val api = Api(httpClient)

        val db = Room.databaseBuilder(
            this,
            MenuDatabase::class.java,
            "menu.db"
        ).build()
        val dao = db.menuDao()

        menuRepository = MenuRepositoryImpl(
            api = api,
            dao = dao
        )
    }
}