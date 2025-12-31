package com.example.littlelemonfinal.domain.usecase

import com.example.littlelemonfinal.domain.repository.NetworkRepository

class NetworkFetchUsecase(
    private val networkRepository: NetworkRepository
) {
    operator fun invoke() = networkRepository.fetch()
}