package dev.sn.littlelemoncoursera.data

import dev.sn.littlelemoncoursera.domain.Dish
import dev.sn.littlelemoncoursera.domain.DishRepository
import dev.sn.littlelemoncoursera.util.Temp
import kotlinx.coroutines.delay

object DishRepositoryImpl: DishRepository {
    override suspend fun getDishList(): List<Dish> {
        delay(1500)
        return Temp.getDishes()
    }
}