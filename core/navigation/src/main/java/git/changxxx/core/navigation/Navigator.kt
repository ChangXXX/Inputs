package git.changxxx.core.navigation

sealed class Route(
    val route: String,
) {

    data object Write : Route("write")

    data object Note : Route("note")

    data class NoteDetail(val id: String) : Route("node_detail")
}