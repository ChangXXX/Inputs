package git.changxxx.feature.write.components.dialog

import android.net.Uri

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

    data class ImageInput(
        val viewType: GalleryViewType = GalleryViewType.Horizontal,
        val uris: List<Uri> = emptyList(),
    ) : WriteBottomSheetState {

        sealed interface GalleryViewType {
            data object Grid : GalleryViewType
            data object Horizontal : GalleryViewType
        }
    }
}

