package git.changxxx.feature.write.components.write

import androidx.compose.runtime.Composable
import git.changxxx.feature.write.model.WriteItem
import git.changxxx.feature.write.model.WriteViewEvent

@Composable
internal fun WriteContentWrapper(
    item: WriteItem,
    setEvent: (WriteViewEvent) -> Unit,
) {
    when (item) {
        is WriteItem.AddItem -> {
            AddContent(setEvent)
        }

        is WriteItem.TextItem -> {
            TextContent(item = item, setEvent = setEvent)
        }
    }
}