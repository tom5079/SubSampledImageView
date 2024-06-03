import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.window.singleWindowApplication
import xyz.quaver.minamo.MinamoImage
import xyz.quaver.minamo.aqua.MinamoImageCanvas
import xyz.quaver.minamo.loadImageFromFile

fun main() = singleWindowApplication {
    var image: MinamoImage? by remember { mutableStateOf(null) }

    DisposableEffect(Unit) {
        image =
            loadImageFromFile("/home/tom5079/Downloads/53658848485_f9517d3193_o.jpg")

        onDispose {
            image?.close()
        }
    }

    SwingPanel(
        modifier = Modifier.fillMaxSize(),
        factory = {
            MinamoImageCanvas().apply {
                setImage(image)
            }
        },
        update = {
            it.reset()
        }
    )
}