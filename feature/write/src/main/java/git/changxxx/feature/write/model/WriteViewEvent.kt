package git.changxxx.feature.write.model

sealed interface WriteViewEvent {
    data object ShowWriteBottomSheet: WriteViewEvent
    data object HideWriteBottomSheet: WriteViewEvent
}