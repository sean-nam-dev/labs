package com.example.littlelemonfinal.domain.repository

interface SharedPrefsRepository {

    fun read(key: String): String

    fun write(key: String, data: String)
}