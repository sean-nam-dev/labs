package com.example.littlelemonfinal.domain

class ReadStartDestinationUsecase(
    private val sharedPrefsRepository: SharedPrefsRepository
) {
    fun invoke() = sharedPrefsRepository.read(Util.START_DESTINATION)
}