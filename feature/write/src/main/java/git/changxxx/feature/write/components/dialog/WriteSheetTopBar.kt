package git.changxxx.feature.write.components.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val ICON_SIZE = 24.dp
private val TOP_BAR_SIZE = 56.dp

@Composable
internal fun WriteSheetTopBar(
    onBackClick: () -> Unit,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(TOP_BAR_SIZE)
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier.size(48.dp)
                .align(Alignment.CenterStart)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(ICON_SIZE),
                contentDescription = "back"
            )
        }

        IconButton(
            onClick = onConfirm,
            modifier = Modifier.size(48.dp)
                .align(Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(ICON_SIZE),
                contentDescription = "save"
            )
        }
    }
}

@Preview
@Composable
internal fun PreviewWriteSheetTopBar() {
    WriteSheetTopBar(
        onBackClick = {},
        onConfirm = {},
    )
}