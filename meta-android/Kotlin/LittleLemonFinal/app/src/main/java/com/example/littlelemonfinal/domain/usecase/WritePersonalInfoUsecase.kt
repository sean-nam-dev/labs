package com.example.littlelemonfinal.domain.usecase

import com.example.littlelemonfinal.domain.repository.SharedPrefsRepository

class WritePersonalInfoUsecase(
    private val sharedPrefsRepository: SharedPrefsRepository
) {
    operator fun invoke(data: Triple<String, String, String>) {
        data.toList().forEachIndexed { index, data ->
            sharedPrefsRepository.write(
                PERSONAL_INFO_LIST[index],
                data
            )
        }
    }

    companion object {
        val PERSONAL_INFO_LIST = listOf(
            "first_name",
            "last_name",
            "email_name"
        )
    }
}