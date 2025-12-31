package com.example.littlelemonfinal.data.remote

import com.example.littlelemonfinal.domain.model.Menu

// Imitating a real API call
class Api {
    fun fetch() = listOf(
        Menu(
            title = "Greek Salad",
            price = "10",
            description = "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true",
            category = "starters"
        ),
        Menu(
            title = "Lemon Desert",
            price = "10",
            description = "Traditional homemade Italian Lemon Ricotta Cake.",
            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/lemonDessert%202.jpg?raw=true",
            category = "desserts"
        ),
        Menu(
            title = "Grilled Fish",
            price = "10",
            description = "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/grilledFish.jpg?raw=true",
            category = "mains"
        ),
        Menu(
            title = "Pasta",
            price = "10",
            description = "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chili, garlic, basil & salted ricotta cheese.",
            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/pasta.jpg?raw=true",
            category = "mains"
        ),
        Menu(
            title = "Bruschetta",
            price = "10",
            description = "Oven-baked bruschetta stuffed with tomatoes and herbs.",
            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/bruschetta.jpg?raw=true",
            category = "starters"
        )
    )
}