package com.example.infosyscodingtest.presentation_layer.components

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.infosyscodingtest.R

@Composable
fun CitiTitle(name: String, isExpanded: Boolean, onCitiClicked: () -> Unit) {

    Row(modifier = Modifier
        .clickable {
            onCitiClicked()
        }
        .background(Color.LightGray)
        .padding(vertical = 8.dp, horizontal = 16.dp)) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.weight(1.0f)
        )


        val rotation by animateFloatAsState(
            targetValue = if (isExpanded) -180f else 0f,
            animationSpec = tween(500)
        )

        Icon(
            painter = painterResource(id = R.drawable.expand_more),
            modifier = Modifier
                .rotate(rotation),
            contentDescription = "",
        )
    }
}