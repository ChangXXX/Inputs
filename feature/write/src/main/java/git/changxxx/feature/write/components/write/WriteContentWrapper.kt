package git.changxxx.feature.write.components.write

import androidx.compose.runtime.Composable
import git.changxxx.feature.write.model.WriteItem

@Composable
internal fun WriteContentWrapper(
    item: WriteItem,
) {
    when (item) {
        is WriteItem.AddItem -> {
            AddContent(item)
        }

        is WriteItem.TextItem -> {
            TextContent(item)
        }
    }
}