package git.changxxx.feature.write.components.dialog.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import git.changxxx.core.designsystem.theme.InputsTheme
import git.changxxx.feature.write.R
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState

@Composable
internal fun ImageViewType(
    viewType: WriteBottomSheetState.ImageInput.GalleryViewType,
    onClickViewType: (WriteBottomSheetState.ImageInput.GalleryViewType) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 12.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier
                .background(
                    color = if (viewType == WriteBottomSheetState.ImageInput.GalleryViewType.Horizontal) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.primaryContainer
                    },
                    shape = RoundedCornerShape(8.dp)
                ),
            onClick = {
                onClickViewType(WriteBottomSheetState.ImageInput.GalleryViewType.Horizontal)
            },
            colors = IconButtonDefaults.iconButtonColors().copy(
                contentColor = if (viewType == WriteBottomSheetState.ImageInput.GalleryViewType.Horizontal) {
                    MaterialTheme.colorScheme.onPrimary
                } else {
                    MaterialTheme.colorScheme.primary
                }
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_horizontal_24dp),
                contentDescription = "Horizontal View Type"
            )
        }
        IconButton(
            modifier = Modifier
                .background(
                    color = if (viewType == WriteBottomSheetState.ImageInput.GalleryViewType.Grid) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.primaryContainer
                    },
                    shape = RoundedCornerShape(8.dp)
                ),
            onClick = {
                onClickViewType(WriteBottomSheetState.ImageInput.GalleryViewType.Grid)
            },
            colors = IconButtonDefaults.iconButtonColors().copy(
                contentColor = if (viewType == WriteBottomSheetState.ImageInput.GalleryViewType.Grid) {
                    MaterialTheme.colorScheme.onPrimary
                } else {
                    MaterialTheme.colorScheme.primary
                }
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_grid_24dp),
                contentDescription = "Horizontal View Type"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewImageViewType() {
    InputsTheme {
        var viewType: WriteBottomSheetState.ImageInput.GalleryViewType by remember { mutableStateOf(WriteBottomSheetState.ImageInput.GalleryViewType.Horizontal) }
        ImageViewType(
            viewType = viewType,
            onClickViewType = {
                viewType = if (viewType == WriteBottomSheetState.ImageInput.GalleryViewType.Horizontal) {
                    WriteBottomSheetState.ImageInput.GalleryViewType.Grid
                } else {
                    WriteBottomSheetState.ImageInput.GalleryViewType.Horizontal
                }
            }
        )
    }
}