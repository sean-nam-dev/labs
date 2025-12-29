package com.example.littlelemonfinal.domain

class WritePersonalInfoUsecase(
    private val sharedPrefsRepository: SharedPrefsRepository
) {
    fun invoke(data: Triple<String, String, String>) {
        data.toList().forEachIndexed { index, data ->
            sharedPrefsRepository.write(
                Util.PERSONAL_INFO_LIST[index],
                data
            )
        }
    }
}