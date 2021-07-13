package reusable

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.unit.dp

@Composable
fun getSlideLogo(currentSlide : Int) {
    val oldAngle by rememberSaveable { mutableStateOf(-120F) }

    val angle: Float by animateFloatAsState(
        targetValue = oldAngle + (currentSlide * 120F),
        animationSpec = tween(
            durationMillis = 2000, // duration
            easing = FastOutSlowInEasing
        ),
    )

    Image(
        bitmap = imageFromResource("drawables/logo.png"),
        modifier = Modifier.size(150.dp).rotate(angle),
        contentDescription = "Logo"
    )
}