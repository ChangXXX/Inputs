package git.changxxx.feature.write.model

import git.changxxx.feature.write.components.dialog.WriteBottomSheetState

sealed interface WriteViewEvent {
    data object ShowWriteBottomSheet : WriteViewEvent
    data object HideWriteBottomSheet : WriteViewEvent
    data class OnTextEditorResult(
        val result: WriteBottomSheetState,
    ) : WriteViewEvent
}