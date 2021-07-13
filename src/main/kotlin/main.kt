import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.desktop.LocalAppWindow
import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import animation.rotateView
import reusable.getButtonSet
import reusable.getSlideLogo
import reusable.myLayouts
import reusable.myStackLayout

fun main() = Window {
    // This holds the number of views to be displayed on screen
    val maxSlides = 9

    // This is to update the slide as we are going left or right
    var currentSlide by remember { mutableStateOf(1) }

    MaterialTheme {

        LocalAppWindow.current.keyboard.onKeyEvent = {
            if (it.type == KeyEventType.KeyDown && it.nativeKeyEvent.keyCode == 37) {
                // This is ARROW LEFT <-
                if (currentSlide > 1)
                    currentSlide--

                true
            } else if (it.type == KeyEventType.KeyDown && it.nativeKeyEvent.keyCode == 39) {
                // This is ARROW RIGHT ->
                if (currentSlide < maxSlides)
                    currentSlide++

                true
            } else {
                true
            }
        }

        Column(
            modifier = Modifier.padding(16.dp).fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                getScreenTitleText(currentSlide)
                getSlideLogo(currentSlide)
            }

            getMyViews(currentSlide)

            Spacer(modifier = Modifier.height(16.dp))
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                if (currentSlide > 1) Button(onClick = {
//                    // Do something here
//                    currentSlide--
//                }) {
//                    Text("Previous")
//                }
//
//                Spacer(modifier = Modifier)
//
//                if (currentSlide < maxSlides) Button(onClick = {
//                    // Do something here to go on next slide
//                    currentSlide++
//                }) {
//                    Text("Next")
//                }
//            }

        }

    }
}

@Composable
fun getScreenTitleText(number: Int) {
    val text = when (number) {
        1 -> {
            ""
        }
        2 -> {
            "About Jetpack Compose"
        }
        3 -> {
            "Basics"
        }
//        4 -> {
//            "State in Compose"
//        }
        4 -> {
            "Text View"
        }
        5 -> {
            "Edit Text"
        }
        6 -> {
            "Vertical & Horizontal Alignment"
        }
        7 -> {
            "Stack Alignment"
        }
        8 -> {
            "Buttons"
        }
//        9 -> {
//            "Animation"
//        }
        else -> {
            ""
        }
    }
    Text(
        text,
        style = TextStyle(fontSize = 36.sp, color = Color.Black)
    )
}

@Composable
fun getMyViews(number: Int) {
    when (number) {
        1 -> {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                getMainText("JetPack Compose")
            }
        }
        2 -> {
            Column {
                getDescriptionText("JetPack Compose is Android's modern toolkit for building Native UI.")
                getDescriptionText("It simplifies and accelerates the UI development.")
                getDescriptionText("It follows declarative UI approach")
                getDescriptionText("Compose UI kit can be used to create UI on Android, Windows, Mac, Linux")
                getDescriptionText("Compose uses skia to render UI, similar to flutter")
            }
        }
        3 -> {
            Column {
                getDescriptionText("UI elements must be marked with @Composable annotation")
                getDescriptionText("To view Preview of composable UI elements, they must be marked with @Preview annotation")
                getDescriptionText("Preview UI elements, must not receive any input")
                getDescriptionText("Composable function will emit your UI")
            }
        }
//        4 -> { // State in Compose
//            Column {
//                getDescriptionText("Persist state across re-composition: 'remember'")
//                getDescriptionText("Persist state across configuration change: 'rememberSaveable'")
//                Spacer(modifier = Modifier.height(16.dp))
//                getDescriptionText("Hoist the state for re-usability and testability")
//                getDescriptionText("Use ViewModel with LiveData and 'observeAsState'")
//            }
//        }
        4 -> { // Text
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Image(
                    bitmap = imageFromResource("drawables/compose_text_view.jpeg"),
                    modifier = Modifier.size(700.dp),
                    contentDescription = "Logo"
                )

                Column {
                    getStylishText()
                }
            }
        }
        5 -> { // Edit Text
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Image(
                    bitmap = imageFromResource("drawables/compose_edit_text.jpeg"),
                    modifier = Modifier.size(600.dp),
                    contentDescription = "Logo"
                )

                Column {
                    myCustomEditText()
                }
            }
        }
        6 -> { // Row & Column
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Image(
                    bitmap = imageFromResource("drawables/compose_view_hierarchy.jpeg"),
                    modifier = Modifier.size(800.dp),
                    contentDescription = "Logo"
                )

                Column {
                    myLayouts()
                }
            }
        }
        7 -> { // Stack
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Image(
                    bitmap = imageFromResource("drawables/compose_stack.jpeg"),
                    modifier = Modifier.size(800.dp),
                    contentDescription = "Logo"
                )

                Column {
                    myStackLayout()
                }
            }
        }
        8 -> { // Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Image(
                    bitmap = imageFromResource("drawables/compose_buttons.jpeg"),
                    modifier = Modifier.size(800.dp),
                    contentDescription = "Logo"
                )

                Column {
                    getButtonSet()
                }
            }
        }
//        9 -> {
//            Column {
//                rotateView()
//            }
//        }
        else -> {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                getMainText("Thank You")
            }
        }
    }
}