package com.example.infosyscodingtest.presentation_layer.components

import CitiItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateMap
import androidx.compose.ui.unit.dp
import com.example.infosyscodingtest.data_layer.local_data_source.models.AuCitiesItem

@Composable
fun CitiList(listCities: List<AuCitiesItem>) {
    val isExpandedMap =
        List(listCities.size) { index: Int -> index to false }.toMutableStateMap()

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        content = {
            listCities.onEachIndexed { index, citiItem ->
                CitiItem(
                    citi = citiItem,
                    isExpanded = isExpandedMap[index] ?: true,
                    onCitiClicked = {
                        isExpandedMap[index] = !(isExpandedMap[index] ?: true)
                    }
                )

            }
        },
        verticalArrangement = Arrangement.spacedBy(1.dp)
    )
}