package com.example.infosyscodingtest.data_layer.local_data_source.repository

import android.content.res.AssetManager
import com.example.infosyscodingtest.data_layer.local_data_source.models.AuCitiesItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import javax.inject.Inject

class LocalRepository @Inject constructor(private val manager: AssetManager) {

    suspend fun loadJsonData(): Result<Any> {

        try {
            val jsonCities =
                manager.open("au_cities.json").bufferedReader().use { it.readText() }.toString()

            val citiListType = object : TypeToken<List<AuCitiesItem>>() {
            }.type

            return Result.success<List<AuCitiesItem>>(Gson().fromJson(jsonCities, citiListType))

        } catch (ioException: IOException) {
            return Result.failure<Exception>(ioException)
        }
    }
}