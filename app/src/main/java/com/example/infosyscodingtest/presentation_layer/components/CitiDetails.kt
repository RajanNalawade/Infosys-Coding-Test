package com.example.infosyscodingtest.presentation_layer.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.infosyscodingtest.data_layer.local_data_source.models.AuCitiesItem

@Composable
fun CitiDetails(auCitiesItem: AuCitiesItem) {
    Column {
        Text(
            text = "Latitude: ${auCitiesItem.lat.toString()}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )

        Text(
            text = "Longitude: ${auCitiesItem.lng.toString()}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )

        Text(
            text = "Admin Name: ${auCitiesItem.adminName.toString()}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )

        Text(
            text = "Population: ${auCitiesItem.population.toString()}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )

        Text(
            text = "Population Proper: ${auCitiesItem.populationProper.toString()}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}