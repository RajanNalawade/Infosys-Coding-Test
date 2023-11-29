package com.example.infosyscodingtest.presentation_layer

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infosyscodingtest.data_layer.local_data_source.models.AuCitiesItem
import com.example.infosyscodingtest.domain_layer.GetCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: GetCitiesUseCase) : ViewModel() {

    val listAuCities = mutableStateOf<List<AuCitiesItem>>(ArrayList())

    val loading = mutableStateOf(false)

    var selected1 = mutableStateOf(false)

    init {
        viewModelScope.launch {

            loading.value = true
            val result = useCase()

            result.onSuccess {
                listAuCities.value = it as List<AuCitiesItem>
            }
            loading.value = false
        }
    }
}