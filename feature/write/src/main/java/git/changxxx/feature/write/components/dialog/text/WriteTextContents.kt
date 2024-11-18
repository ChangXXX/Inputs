package git.changxxx.feature.write.components.dialog.text

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState
import git.changxxx.feature.write.components.dialog.WriteSheetTopBar

@Composable
internal fun WriteTextContents(
    onBackClick: () -> Unit,
    onConfirm: () -> Unit,
    writeTextItem: WriteBottomSheetState.TextInput
) {
    Column {
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
    }
}