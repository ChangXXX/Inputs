package git.changxxx.feature.write.components.write

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import git.changxxx.feature.write.model.WriteItem

@Composable
internal fun TextContent(
    item: WriteItem.TextItem
) {
    WriteItemCard {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = item.text,
                style = TextStyle(
                    fontSize = item.textSize.sp,
                    fontWeight = if (item.textStyle.isBold) {
                        FontWeight.Bold
                    }  else {
                        FontWeight.Normal
                    },
                    fontStyle = if (item.textStyle.isItalic) {
                        FontStyle.Italic
                    } else {
                        FontStyle.Normal
                    },
                    textDecoration = TextDecoration.combine(
                        listOfNotNull(
                            if (item.textStyle.isUnderline) TextDecoration.Underline else null,
                            if (item.textStyle.isStrikethrough) TextDecoration.LineThrough else null
                        )
                    )
                ),
            )
        }
    }
}