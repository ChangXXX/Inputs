package git.changxxx.feature.write.components.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun WriteTextContents(
    onBackClick: () -> Unit,
    onConfirm: () -> Unit,
) {
    Column {
        WriteSheetTopBar(
            onBackClick = onBackClick,
            onConfirm = onConfirm
        )
    }
}