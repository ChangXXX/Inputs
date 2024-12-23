package git.changxxx.feature.write.components.write

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import git.changxxx.feature.write.model.WriteViewEvent

@Composable
internal fun AddContent(
    onClickAddItem: (WriteViewEvent) -> Unit,
) {
    WriteItemCard {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = { onClickAddItem(WriteViewEvent.ShowWriteBottomSheet) },
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Item Button"
                )
            }
        }
    }
}