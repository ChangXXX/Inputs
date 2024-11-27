package git.changxxx.feature.write.components.dialog.initial

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState
import git.changxxx.feature.write.components.write.WriteItemCard
import git.changxxx.feature.write.model.WriteItem

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
                        .fillMaxSize()
                        .height(100.dp)
                        .clickable {
                            onChangedCurrentContent(WriteBottomSheetState.TextInput())
                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "TEXT",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Text Item"
                    )
                }
            }
        }
        item {
            WriteItemCard(
                modifier = Modifier.clickable {
                    onChangedCurrentContent(WriteBottomSheetState.TextInput())
                }
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Add Text Item"
                    )
                }
            }
        }
    }
}

@Composable
fun TwoByTwoGridScreen() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2열로 고정
        modifier = Modifier.fillMaxSize(),
        content = {
            items(4) { index -> // 4개의 아이템만 표시
                GridItem(index)
            }
        }
    )
}

@Composable
fun GridItem(index: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            text = "Item $index",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
        )
    }
}