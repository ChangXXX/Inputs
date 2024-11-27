package git.changxxx.feature.write.components.dialog

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import git.changxxx.feature.write.components.dialog.initial.WriteBottomSheetContents
import git.changxxx.feature.write.components.dialog.text.WriteTextContents
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WriteBottomSheetDialog(
    onDismiss: () -> Unit,
    onWriteTextConfirm: (WriteBottomSheetState.TextInput) -> Unit,
) {
    val sheetState = rememberModalBottomSheetState()
    var currentContent by remember { mutableStateOf<WriteBottomSheetState>(WriteBottomSheetState.Initial) }
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = {
            onDismiss()
            scope.launch {
                sheetState.hide()
            }
        },
    ) {
        when (currentContent) {
            is WriteBottomSheetState.Initial -> {
                WriteBottomSheetContents(
                    onChangedCurrentContent = { currentContent = it }
                )
            }

            is WriteBottomSheetState.TextInput -> {
                WriteTextContents(
                    onBackClick = { currentContent = WriteBottomSheetState.Initial },
                    onConfirm = { onWriteTextConfirm(currentContent as WriteBottomSheetState.TextInput) },
                    onChangedCurrentContent = { currentContent = it },
                    writeTextItem = currentContent as WriteBottomSheetState.TextInput
                )
            }
        }
    }
}