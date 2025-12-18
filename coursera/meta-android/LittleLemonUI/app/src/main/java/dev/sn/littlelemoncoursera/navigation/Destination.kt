package dev.sn.littlelemoncoursera.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {
    val baseRoute: String
        get() = "dev.sn.littlelemoncoursera.navigation."

    @Serializable
    data object HomeGraph : Destination

    @Serializable
    data object HomeScreen : Destination {
        override fun toString(): String {
            return baseRoute + "HomeScreen"
        }
    }

    @Serializable
    data class DetailScreen(val id: Int) : Destination

    @Serializable
    data object DinnerMenuGraph : Destination

    @Serializable
    data object DinnerMenuScreen : Destination {
        override fun toString(): String {
            return baseRoute + "DinnerMenuScreen"
        }
    }

    @Serializable
    data class DinnerMenuDetailScreen(val index: Int) : Destination
}