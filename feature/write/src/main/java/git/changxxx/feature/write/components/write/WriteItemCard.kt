package git.changxxx.feature.write.components.write

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val CARD_PADDING = 12.dp
private val BORDER_WIDTH = 1.dp
private val CARD_ELEVATION = 10.dp

@Composable
internal fun WriteItemCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(CARD_PADDING),
        border = BorderStroke(width = BORDER_WIDTH, color = MaterialTheme.colorScheme.primaryContainer),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = CARD_ELEVATION)
    ) {
        content()
    }
}