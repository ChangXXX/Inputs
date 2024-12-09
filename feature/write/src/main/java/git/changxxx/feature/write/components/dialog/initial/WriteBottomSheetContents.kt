package git.changxxx.feature.write.components.dialog.initial

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import git.changxxx.feature.write.R
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState
import git.changxxx.feature.write.components.write.WriteItemCard

private val GAP_BETWEEN_TEXT_ICON = 8.dp

@Composable
internal fun WriteBottomSheetContents(
    onChangedCurrentContent: (WriteBottomSheetState) -> Unit,
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
    ) {
        item {
            WriteItemCard {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onChangedCurrentContent(WriteBottomSheetState.TextInput())
                        }
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "TEXT",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(GAP_BETWEEN_TEXT_ICON))
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Text Item",
                        tint = Color.Black
                    )
                }
            }
        }
        item {
            WriteItemCard{
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onChangedCurrentContent(WriteBottomSheetState.ImageInput())
                        }
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Images",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(GAP_BETWEEN_TEXT_ICON))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_image_24dp),
                        contentDescription = "Add Image Items",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}