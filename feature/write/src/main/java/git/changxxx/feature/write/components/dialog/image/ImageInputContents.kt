package git.changxxx.feature.write.components.dialog.image

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState
import git.changxxx.feature.write.components.dialog.WriteSheetTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ImageInputContents(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onConfirm: () -> Unit,
    onChangedCurrentContent: (WriteBottomSheetState.ImageInput) -> Unit,
    writeImageItem: WriteBottomSheetState.ImageInput,
) {
    Column(
        modifier = modifier
    ) {
        WriteSheetTopBar(
            onBackClick = onBackClick,
            onConfirm = onConfirm
        )
        CompositionLocalProvider(LocalRippleConfiguration provides null) {
            ImageViewType(
                viewType = writeImageItem.viewType,
                onClickViewType = { onChangedCurrentContent(writeImageItem.copy(viewType = it)) }
            )
        }
    }
}