package git.changxxx.inputs.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import git.changxxx.core.navigation.Route
import git.changxxx.feature.note.NoteScreen
import git.changxxx.feature.notedetail.NoteDetailScreen
import git.changxxx.feature.write.WriteNote
import git.changxxx.inputs.feature.favorites.FavoritesScreen

@Composable
fun InputsNavHost(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Route.Note.route,
    ) {
        composable(Route.Note.route) {
            NoteScreen()
        }
        composable(Route.Write.route) {
            WriteNote()
        }
        composable(Route.Favorites.route) {
            FavoritesScreen()
        }
        composable(Route.NoteDetail.route) {
            NoteDetailScreen()
        }
    }
}