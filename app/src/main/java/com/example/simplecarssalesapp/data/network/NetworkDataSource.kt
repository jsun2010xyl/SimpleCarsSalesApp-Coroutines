package com.example.simplecarssalesapp.data.network

import androidx.lifecycle.LiveData
import com.example.simplecarssalesapp.data.models.Item

interface NetworkDataSource {
    val downloadedData: LiveData<Item>

    suspend fun fetchData(

    )
}