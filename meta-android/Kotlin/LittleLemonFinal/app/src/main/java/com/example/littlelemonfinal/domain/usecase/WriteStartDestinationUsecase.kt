package com.example.littlelemonfinal.domain.usecase

import com.example.littlelemonfinal.domain.repository.SharedPrefsRepository
import com.example.littlelemonfinal.domain.Util

class WriteStartDestinationUsecase(
    private val sharedPrefsRepository: SharedPrefsRepository
) {
    operator fun invoke(data: String) {
        sharedPrefsRepository.write(
            Util.START_DESTINATION,
            data
        )
    }
}