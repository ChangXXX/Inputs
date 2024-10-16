package git.changxxx.feature.write

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import git.changxxx.core.designsystem.theme.InputsTheme

@Composable
fun WriteNote() {
    Text(text = "WriteNote Composable")
}

@Preview
@Composable
fun WriteNotePreview() {
    InputsTheme {
        WriteNote()
    }
}