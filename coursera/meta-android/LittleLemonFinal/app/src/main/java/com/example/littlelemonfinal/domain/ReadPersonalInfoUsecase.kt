package com.example.littlelemonfinal.domain

class ReadPersonalInfoUsecase(
    private val sharedPrefsRepository: SharedPrefsRepository
) {
    fun invoke() = Triple(
        sharedPrefsRepository.read(Util.FIRST_NAME),
        sharedPrefsRepository.read(Util.LAST_NAME),
        sharedPrefsRepository.read(Util.EMAIL)
    )
}