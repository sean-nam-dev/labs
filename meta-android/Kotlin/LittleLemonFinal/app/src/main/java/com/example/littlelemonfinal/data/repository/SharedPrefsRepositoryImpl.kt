package com.example.littlelemonfinal.data.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.littlelemonfinal.domain.repository.SharedPrefsRepository

class SharedPrefsRepositoryImpl(
    private val sharedPrefs: SharedPreferences
) : SharedPrefsRepository {

    override fun read(key: String) = sharedPrefs.getString(key, "")!!

    override fun write(key: String, data: String) = sharedPrefs.edit {
        putString(
            key,
            data
        )
    }
}