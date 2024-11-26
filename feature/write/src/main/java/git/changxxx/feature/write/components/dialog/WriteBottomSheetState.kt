package git.changxxx.feature.write.components.dialog

internal const val DEFAULT_TEXT_SIZE = 16

sealed interface WriteBottomSheetState {
    data object Initial : WriteBottomSheetState
    data class TextInput(
        val textStyle: TextStyle = TextStyle(),
        val text: String = "",
        val textSize: Int = DEFAULT_TEXT_SIZE,
    ) : WriteBottomSheetState {

        data class TextStyle(
            val isBold: Boolean = false,
            val isItalic: Boolean = false,
            val isUnderline: Boolean = false,
            val isStrikethrough: Boolean = false,
        )
    }
}

