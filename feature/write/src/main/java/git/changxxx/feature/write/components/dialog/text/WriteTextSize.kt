package git.changxxx.feature.write.components.dialog.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val UPPER_BOUND_TEXT_SIZE = 32
private const val LOWER_BOUND_TEXT_SIZE = 12

@Composable
internal fun WriteTextSize(
    onSizeChanged: (Int) -> Unit,
    textSize: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Size",
            modifier = Modifier.weight(1f)
        )
        Row(
            modifier = Modifier.weight(2f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { if (textSize < UPPER_BOUND_TEXT_SIZE) onSizeChanged(textSize + 1) }) {
                Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Increase Font Size")
            }
            Text(text = textSize.toString(), fontSize = 16.sp)
            IconButton(onClick = { if (textSize > LOWER_BOUND_TEXT_SIZE) onSizeChanged(textSize - 1) }) {
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Decrease Font Size")
            }
        }
    }
}