package dev.sn.littlelemoncoursera.util

sealed class Filter {

    data object All: Filter()

    data object Drinks: Filter()

    data object Food: Filter()

    data object Dessert: Filter()
}