package git.changxxx.feature.write.model

import git.changxxx.feature.write.components.dialog.DEFAULT_TEXT_SIZE
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState.TextInput.TextStyle

sealed interface WriteItem {

    data object AddItem: WriteItem

    data class TextItem(
        val textStyle: TextStyle = TextStyle(),
        val text: String = "",
        val textSize: Int = DEFAULT_TEXT_SIZE,
    ) : WriteItem
}