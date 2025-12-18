package dev.sn.littlelemoncoursera.domain

interface DishRepository {
    suspend fun getDishList(): List<Dish>
}