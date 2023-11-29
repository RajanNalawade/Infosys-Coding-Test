package com.example.infosyscodingtest.presentation_layer.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainTitle(name: String, change: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {

        Text(
            text = name,
            textAlign = TextAlign.Start,
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.weight(4.0f)
        )

        Switch(
            checked = change,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Black,
                uncheckedThumbColor = Color.Black,
                checkedTrackColor = Color.White,
                uncheckedTrackColor = Color.Gray
            ),
            modifier = Modifier.weight(1.0f)
        )


    }
}