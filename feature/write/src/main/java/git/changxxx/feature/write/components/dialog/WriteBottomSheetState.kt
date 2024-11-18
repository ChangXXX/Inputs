package git.changxxx.feature.write.components.dialog

sealed interface WriteBottomSheetState {
    data object Initial : WriteBottomSheetState
    data class TextInput(
        val textStyle: List<TextStyle> = listOf(
            TextStyle.BOLD, TextStyle.ITALIC, TextStyle.UNDERLINE, TextStyle.STRIKETHROUGH
        ),
        val text: String = "",
        val textSize: TextSize = TextSize.TEXT_SIZE_16,
    ) : WriteBottomSheetState {

        sealed class TextStyle(
            val isSelected: Boolean,
        ) {

            data object BOLD: TextStyle(false)
            data object ITALIC: TextStyle(false)
            data object UNDERLINE: TextStyle(false)
            data object STRIKETHROUGH: TextStyle(false)
        }

        enum class TextSize {
            TEXT_SIZE_16, TEXT_SIZE_24, TEXT_SIZE_32
        }
    }

}