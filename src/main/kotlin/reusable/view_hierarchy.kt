package reusable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun myLayouts() {
    Row(
        modifier = Modifier.width(200.dp).background(Color.Yellow),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(50.dp).clip(CircleShape).background(Color.Red))
        Box(Modifier.size(50.dp).background(Color.Blue))
        Column {
            Box(Modifier.size(50.dp).clip(RoundedCornerShape(12.dp)).background(Color.Green))
            Box(Modifier.size(50.dp).background(Color.Black))
        }
    }
}

@Composable
fun myStackLayout() {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(Modifier.size(100.dp).background(Color.Blue))
        Box(Modifier.size(75.dp).clip(RoundedCornerShape(12.dp)).background(Color.Green))
        Box(modifier = Modifier.size(50.dp).clip(CircleShape).background(Color.Red))
    }
}