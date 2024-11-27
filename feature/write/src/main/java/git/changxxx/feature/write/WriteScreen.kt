package git.changxxx.feature.write

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import git.changxxx.feature.write.components.dialog.WriteBottomSheetDialog
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState
import git.changxxx.feature.write.components.write.WriteContentWrapper
import git.changxxx.feature.write.model.WriteItem
import git.changxxx.feature.write.model.WriteViewEvent

@Composable
fun WriteScreen(
    writeViewModel: WriteViewModel = hiltViewModel(),
) {
    val state = writeViewModel.writeViewState.collectAsStateWithLifecycle().value

    WriteNote(
        state.writeItemList,
        state.showWriteBottomSheet,
        writeViewModel::setEvent
    )
}

@Composable
private fun WriteNote(
    writeItems: List<WriteItem>,
    writeBottomSheetState: Boolean,
    setEvent: (WriteViewEvent) -> Unit,
) {

    if (writeBottomSheetState) {
        WriteBottomSheetDialog(
            onDismiss = {
                setEvent(WriteViewEvent.HideWriteBottomSheet)
            },
            onWriteTextConfirm = {
                setEvent(WriteViewEvent.OnTextEditorResult(it))
            }
        )
    }

    Column {
        LazyColumn {
            items(
                items = writeItems
            ) { item ->
                WriteContentWrapper(
                    item = item,
                    setEvent = setEvent
                )
            }
        }
    }
}