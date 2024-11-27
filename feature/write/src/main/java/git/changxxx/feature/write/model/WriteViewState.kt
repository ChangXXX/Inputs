package git.changxxx.feature.write.model

data class WriteViewState(
    val writeItemList: List<WriteItem> = listOf(WriteItem.AddItem),
    val showWriteBottomSheet: Boolean = false
)