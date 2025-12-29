package com.example.littlelemonfinal.navigation

import kotlinx.serialization.Serializable

sealed class Destination {

    @Serializable
    data object Register : Destination()

    @Serializable
    data object LogOut : Destination()

    @Serializable
    data object Home : Destination()
}
