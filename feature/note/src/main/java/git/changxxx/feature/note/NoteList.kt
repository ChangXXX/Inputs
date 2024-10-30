package git.changxxx.feature.note

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import git.changxxx.core.navigation.Route

@Composable
fun NoteList(
    navHostController: NavHostController
) {
    Button(onClick = { navHostController.navigate(Route.Write.route) }) {
        Text(text = "Go to Write")
    }
}