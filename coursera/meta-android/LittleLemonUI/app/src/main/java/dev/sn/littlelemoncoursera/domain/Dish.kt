package dev.sn.littlelemoncoursera.domain

data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageResource: Int
)