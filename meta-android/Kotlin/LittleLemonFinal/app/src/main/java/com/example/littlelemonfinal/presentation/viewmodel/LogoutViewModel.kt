package com.example.littlelemonfinal.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.littlelemonfinal.domain.usecase.ReadPersonalInfoUsecase
import com.example.littlelemonfinal.domain.usecase.WritePersonalInfoUsecase
import com.example.littlelemonfinal.domain.usecase.WriteStartDestinationUsecase
import com.example.littlelemonfinal.navigation.Destination
import com.example.littlelemonfinal.presentation.action.LogoutAction

class LogoutViewModel(
    private val readPersonalInfoUsecase: ReadPersonalInfoUsecase,
    private val writePersonalInfoUsecase: WritePersonalInfoUsecase,
    private val writeStartDestinationUsecase: WriteStartDestinationUsecase
) : ViewModel(), LogoutAction {

    override fun logout() {
        writePersonalInfoUsecase(Triple("", "", ""))
        writeStartDestinationUsecase(Destination.Register.toString())
    }

    override fun getData(): Triple<String, String, String> = readPersonalInfoUsecase()
}