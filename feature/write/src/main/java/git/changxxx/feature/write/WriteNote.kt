package git.changxxx.feature.write

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import git.changxxx.core.designsystem.theme.InputsTheme
import git.changxxx.feature.write.model.WriteItem

@Composable
internal fun WriteNote(
    writeViewModel: WriteViewModel = hiltViewModel(),
) {
    val writeItems by writeViewModel.writeViewState.writeItemList.collectAsStateWithLifecycle()

    Text(
        text = "add TextItem",
        modifier = Modifier.clickable {
            writeViewModel.addTextItem()
        }
    )
    LazyColumn {
        items(
            key = { item -> item.id },
            items = writeItems
        ) { item ->
            when(item) {
                WriteItem.AddItem -> {
                    Text("Add Item Btn")
                }
                is WriteItem.TextItem -> {
                    Text("Text Item Btn")
                }
            }
        }
    }
}

@Preview
@Composable
fun WriteNotePreview() {
    InputsTheme {
        WriteNote()
    }
}