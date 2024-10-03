package com.nura.vechiledetails.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nura.vechiledetails.R

@Composable
fun MostPopularBike() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(10.dp, 10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_favorite_border_24),
                contentDescription = "liked bikes",
                modifier = Modifier.align(Alignment.End)
            )

            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "bike image"
            )

            Text(text = "Bike name")
            Text(text = "Model number")
            Row {
                Text(text = "price", modifier = Modifier.weight(0.2f))
                Spacer(modifier = Modifier.weight(0.6f))
                Text(text = "rating", modifier = Modifier.weight(0.2f))
            }
        }
    }
}

@Preview
@Composable
fun Test() {
    MostPopularBike()
}