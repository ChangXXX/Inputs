package git.changxxx.feature.write.components.dialog

sealed interface WriteBottomSheetState {
    data object Initial : WriteBottomSheetState
    data class TextInput(
        val textStyle: List<TextStyle> = listOf(
            TextStyle.BOLD, TextStyle.ITALIC, TextStyle.UNDERLINE, TextStyle.STRIKETHROUGH
        ),
        val text: String = "",
        val textSize: Int = defaultTextSize,
    ) : WriteBottomSheetState {

        sealed class TextStyle(
            val isSelected: Boolean,
        ) {

            data object BOLD : TextStyle(false)
            data object ITALIC : TextStyle(false)
            data object UNDERLINE : TextStyle(false)
            data object STRIKETHROUGH : TextStyle(false)
        }
    }
}

private const val defaultTextSize = 16