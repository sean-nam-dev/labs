package dev.sn.littlelemoncoursera.util

import dev.sn.littlelemoncoursera.R
import dev.sn.littlelemoncoursera.domain.Dish
import dev.sn.littlelemoncoursera.domain.Product

object Temp {

    fun getDishes() = listOf(
        Dish(
            1,
            "Greek Salad",
            "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
            12.99,
            R.drawable.greeksalad
        ),
        Dish(
            2,
            "Lemon Desert",
            "Traditional homemade Italian Lemon Ricotta Cake.",
            8.99,
            R.drawable.lemondessert
        ),
        Dish(
            3,
            "Bruschetta",
            "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
            4.99,
            R.drawable.bruschetta
        ),
        Dish(
            4,
            "Grilled Fish",
            "Fish marinated in fresh orange and lemon juice. Grilled with orange and lemon wedges.",
            19.99,
            R.drawable.grilledfish
        ),
        Dish(
            5,
            "Pasta",
            "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chilli, garlic, basil & salted ricotta cheese.",
            8.99,
            R.drawable.pasta
        ),
        Dish(
            6,
            "Lasagne",
            "Oven-baked layers of pasta stuffed with Bolognese sauce, béchamel sauce, ham, Parmesan & mozzarella cheese .",
            7.99,
            R.drawable.lasagne
        )
    )

    fun getProducts() = listOf(
        Product("Black tea", 3.00, "Drinks", R.drawable.black_tea),
        Product("Green tea", 3.00, "Drinks", R.drawable.green_tea),
        Product("Espresso", 5.00, "Drinks", R.drawable.espresso),
        Product("Cappuccino", 8.00, "Drinks", R.drawable.cappuccino),
        Product("Latte", 8.00, "Drinks", R.drawable.latte),
        Product("Mocha", 10.00, "Drinks", R.drawable.mocha),
        Product("Boeuf bourguignon", 15.00, "Food", R.drawable.boeuf_bourguignon),
        Product("Bouillabaisse", 20.00, "Food", R.drawable.bouillabaisse),
        Product("Lasagna", 15.00, "Food", R.drawable.lasagna),
        Product("Onion soup", 12.00, "Food", R.drawable.onion_soup),
        Product("Salmon en papillote", 25.00, "Food", R.drawable.salmon_en_papillote),
        Product("Quiche Lorraine", 17.00, "Dessert", R.drawable.quiche_lorraine),
        Product("Custard tart", 14.00, "Dessert", R.drawable.custard_tart),
        Product("Croissant", 7.00, "Dessert", R.drawable.croissant),
    )
}