package git.changxxx.feature.write.model

sealed class WriteItem(open val id: Int) {
    data object AddItem: WriteItem(0)
    data class TextItem(override val id: Int) : WriteItem(id)
}