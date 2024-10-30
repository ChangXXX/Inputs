package git.changxxx.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Route(
    val route: String,
    val navArgs: List<NamedNavArgument> = emptyList()
) {

    data object Write : Route("write")

    data object Note : Route("note")

    data object NoteDetail : Route(
        route = "node_detail",
        navArgs = listOf(navArgument(ARGS_NOTE_ID) { type = NavType.StringType })
    ) {
        fun createRoute(noteId: String) = "$route/$noteId"
    }

    data object Favorites : Route("favorites")

    companion object {
        const val ARGS_NOTE_ID = "noteId"
    }
}