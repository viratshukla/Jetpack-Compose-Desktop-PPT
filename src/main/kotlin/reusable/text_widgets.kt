import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun getDescriptionText(text: String) {
    Row(
        modifier = Modifier.padding(PaddingValues(bottom = 12.dp, top = 12.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape)
                .background(Color.Black)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text,
            style = TextStyle(fontSize = 24.sp, color = Color.Black)
        )
    }
}

@Composable
fun getMainText(text: String) {
    Text(text, style = TextStyle(fontSize = 48.sp, color = Color.Black))
}

@Composable
fun getStylishText() {
    var isSelected by remember { mutableStateOf(false) }

    // Create variable horizontalGradient and inside color property define start and end color
    val horizontalGradient = Brush.horizontalGradient(
        colors = if (isSelected) listOf(Color.Blue, Color.Cyan, Color.Red)
                    else listOf(Color.Red, Color.Cyan, Color.Blue),
        0f,
        Float.POSITIVE_INFINITY
    )

    // Modifier properties start from bottom to top
    Text(
        text = "Sharing is Caring",
        modifier = Modifier
            .border(width = 2.dp, color = Color.Blue, shape = RoundedCornerShape(size = 8.dp))
            .padding(24.dp)
            .background(brush = horizontalGradient)
            .padding(24.dp)
            .clickable(onClick = { isSelected = !isSelected })
    )
}