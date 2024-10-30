package git.changxxx.feature.note

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun NoteScreen(
    navHostController: NavHostController
) {
    NoteList(navHostController)
}