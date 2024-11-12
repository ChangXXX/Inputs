package git.changxxx.feature.write.components.dialog

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
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WriteBottomSheetDialog(
    onDismiss: () -> Unit,
    onClickConfirm: () -> Unit,
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
        }
    ) {
        Text(text = "add Text?")
    }
}