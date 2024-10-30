package git.changxxx.feature.note

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import git.changxxx.core.designsystem.theme.InputsTheme
import git.changxxx.core.navigation.Route

@Composable
fun NoteList(
    navHostController: NavHostController
) {
    Button(onClick = { navHostController.navigate(Route.Write.route) }) {
        Text(text = "Go to Write")
    }
}