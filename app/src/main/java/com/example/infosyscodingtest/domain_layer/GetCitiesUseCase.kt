package com.example.infosyscodingtest.domain_layer

import com.example.infosyscodingtest.data_layer.local_data_source.repository.LocalRepository
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(private val repository: LocalRepository) {

    suspend operator fun invoke(): Result<Any> = repository.loadJsonData()

}