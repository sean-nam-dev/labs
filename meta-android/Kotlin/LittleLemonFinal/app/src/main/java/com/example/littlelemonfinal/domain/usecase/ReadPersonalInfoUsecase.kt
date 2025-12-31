package com.example.littlelemonfinal.domain.usecase

import com.example.littlelemonfinal.domain.repository.SharedPrefsRepository

class ReadPersonalInfoUsecase(
    private val sharedPrefsRepository: SharedPrefsRepository
) {
    operator fun invoke() = Triple(
        sharedPrefsRepository.read(FIRST_NAME),
        sharedPrefsRepository.read(LAST_NAME),
        sharedPrefsRepository.read(EMAIL)
    )

    companion object {
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val EMAIL = "email_name"
    }
}