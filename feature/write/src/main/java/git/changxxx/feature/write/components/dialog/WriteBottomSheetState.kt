package git.changxxx.feature.write.components.dialog

sealed interface WriteBottomSheetState {
    data object Initial : WriteBottomSheetState
    data object TextInput : WriteBottomSheetState
}