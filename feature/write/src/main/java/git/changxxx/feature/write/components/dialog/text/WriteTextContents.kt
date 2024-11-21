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
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onConfirm: () -> Unit,
    onChangedCurrentContent: (WriteBottomSheetState) -> Unit,
    writeTextItem: WriteBottomSheetState.TextInput,
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 8.dp)
    ) {
        WriteSheetTopBar(
            onBackClick = onBackClick,
            onConfirm = onConfirm
        )
        WriteTextStyle(
            style = writeTextItem.textStyle,
            onClickTextStyle = { style ->
                onChangedCurrentContent(writeTextItem.copy(textStyle = style))
            }
        )
        WriteTextSize(
            textSize = writeTextItem.textSize,
            onSizeChanged = { newSize ->
                onChangedCurrentContent(writeTextItem.copy(textSize = newSize))
            },
        )
        WriteEditText(
            text = writeTextItem.text,
            fontSize = writeTextItem.textSize,
            fontStyle = writeTextItem.textStyle,
            onTextChanged = { text ->
                onChangedCurrentContent(writeTextItem.copy(text = text))
            }
        )
    }
}