package git.changxxx.feature.write.components.dialog.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState
import git.changxxx.feature.write.components.dialog.WriteSheetTopBar

@Composable
internal fun WriteTextContents(
    onBackClick: () -> Unit,
    onConfirm: () -> Unit,
    writeTextItem: WriteBottomSheetState.TextInput
) {
    Column (
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 8.dp)
    ) {
        WriteSheetTopBar(
            onBackClick = onBackClick,
            onConfirm = onConfirm
        )
        WriteTextStyle(
            onClickTextStyle = {
                onConfirm()
            },
            items = writeTextItem.textStyle
        )
        WriteTextSize(
            onSizeChanged = {},
            textSize = writeTextItem.textSize,
        )
    }
}