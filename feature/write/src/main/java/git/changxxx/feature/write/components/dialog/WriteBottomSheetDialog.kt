package git.changxxx.feature.write.components.dialog

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
                Button(onClick = { currentContent = WriteBottomSheetState.TextInput() }) {
                    Text(text = "add Text?")
                }
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