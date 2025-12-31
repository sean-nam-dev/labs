package com.example.littlelemonfinal.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.littlelemonfinal.domain.usecase.WritePersonalInfoUsecase
import com.example.littlelemonfinal.domain.usecase.WriteStartDestinationUsecase
import com.example.littlelemonfinal.navigation.Destination
import com.example.littlelemonfinal.presentation.action.RegisterAction

class RegisterViewModel(
    private val writeStartDestinationUsecase: WriteStartDestinationUsecase,
    private val writePersonalInfoUsecase: WritePersonalInfoUsecase
) : ViewModel(), RegisterAction {

    override fun changeStartNavigation() {
        writeStartDestinationUsecase(Destination.Home.toString())
    }

    override fun savePersonalInfo(data: Triple<String, String, String>) {
        writePersonalInfoUsecase(data)
    }
}