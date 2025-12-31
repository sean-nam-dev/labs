package com.example.littlelemonfinal.domain.repository

import com.example.littlelemonfinal.domain.model.Menu

interface NetworkRepository {

    fun fetch(): List<Menu>
}