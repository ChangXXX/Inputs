package git.changxxx.feature.note

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import git.changxxx.core.designsystem.theme.InputsTheme

@Composable
fun NoteList() {
    Text(text = "NoteList Composable")
}

@Preview
@Composable
fun NoteListPreview() {
    InputsTheme {
        NoteList()
    }
}