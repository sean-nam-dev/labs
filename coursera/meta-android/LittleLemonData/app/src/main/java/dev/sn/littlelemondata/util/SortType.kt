package dev.sn.littlelemondata.util

sealed class SortType {

    data object Name : SortType()

    data object Price : SortType()
}