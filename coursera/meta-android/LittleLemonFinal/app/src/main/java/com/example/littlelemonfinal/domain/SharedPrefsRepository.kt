package com.example.littlelemonfinal.domain

interface SharedPrefsRepository {

    fun read(key: String): String

    fun write(key: String, data: String)
}