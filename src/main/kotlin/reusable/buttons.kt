package reusable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun getButtonSet() {
    Column {
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = ButtonDefaults.elevation(defaultElevation = 20.dp)
        ) {
            Text(text = "Rounded")
        }

        OutlinedButton(
            onClick = { /*TODO*/ }, border = BorderStroke(1.dp, Color.Red),
            modifier = Modifier.padding(8.dp), shape = RoundedCornerShape(12.dp),
        ) {
            Text(text = "Outlined Icon")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp)
            )
        }
    }
}