package com.example.littlelemonfinal.domain

class WriteStartDestinationUsecase(
    private val sharedPrefsRepository: SharedPrefsRepository
) {
    fun invoke(data: String) = sharedPrefsRepository.write(
        Util.START_DESTINATION,
        data
    )
}