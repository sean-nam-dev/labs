package dev.sn.littlelemoncoursera.util

sealed class Sort {

    data object AZ : Sort()

    data object PriceAscending : Sort()

    data object PriceDescending : Sort()
}
