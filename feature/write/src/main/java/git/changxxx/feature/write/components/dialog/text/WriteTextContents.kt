package git.changxxx.feature.write.components.dialog.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState
import git.changxxx.feature.write.components.dialog.WriteSheetTopBar

@Composable
internal fun WriteTextContents(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onConfirm: () -> Unit,
    onChangedCurrentContent: (WriteBottomSheetState.TextInput) -> Unit,
    writeTextItem: WriteBottomSheetState.TextInput,
) {
    Column(
        modifier = modifier
    ) {
        WriteSheetTopBar(
            onBackClick = onBackClick,
            onConfirm = onConfirm
        )
        WriteTextStyle(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            style = writeTextItem.textStyle,
            onClickTextStyle = { style ->
                onChangedCurrentContent(writeTextItem.copy(textStyle = style))
            }
        )
        WriteTextSize(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textSize = writeTextItem.textSize,
            onSizeChanged = { newSize ->
                onChangedCurrentContent(writeTextItem.copy(textSize = newSize))
            },
        )
        WriteEditText(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            text = writeTextItem.text,
            fontSize = writeTextItem.textSize,
            fontStyle = writeTextItem.textStyle,
            onTextChanged = { text ->
                onChangedCurrentContent(writeTextItem.copy(text = text))
            }
        )
    }
}