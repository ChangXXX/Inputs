package git.changxxx.feature.write

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import git.changxxx.feature.write.components.dialog.WriteBottomSheetDialog
import git.changxxx.feature.write.components.write.WriteContentWrapper
import git.changxxx.feature.write.model.WriteItem
import git.changxxx.feature.write.model.WriteViewEvent
import timber.log.Timber

@Composable
internal fun WriteNote(
    writeViewModel: WriteViewModel = hiltViewModel(),
) {
    val writeItems by writeViewModel.writeViewState.writeItemList.collectAsStateWithLifecycle()
    val writeBottomSheetState by writeViewModel.writeViewState.showWriteBottomSheet.collectAsStateWithLifecycle()

    if (writeBottomSheetState) {
        WriteBottomSheetDialog(
            onDismiss = {
                writeViewModel.setEvent(WriteViewEvent.HideWriteBottomSheet)
            },
            onWriteTextConfirm = {
                writeViewModel.setEvent(WriteViewEvent.OnTextEditorResult(it))
            }
        )
    }

    Column{
        LazyColumn {
            items(
                items = writeItems
            ) { item ->
                WriteContentWrapper(item = item)
            }
        }
    }
}