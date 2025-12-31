package com.example.littlelemonfinal.data.repository

import com.example.littlelemonfinal.data.remote.Api
import com.example.littlelemonfinal.domain.repository.NetworkRepository

class NetworkRepositoryImpl(
    private val api: Api
) : NetworkRepository {
    override fun fetch() = api.fetch()
}