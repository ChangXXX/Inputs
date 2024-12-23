package git.changxxx.feature.write.components.dialog.text

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import git.changxxx.feature.write.R
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState.TextInput.TextStyle

private val ICON_SIZE = 24.dp

@Composable
internal fun WriteTextStyle(
    modifier: Modifier = Modifier,
    style: TextStyle,
    onClickTextStyle: (TextStyle) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Style",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Row(
            modifier = Modifier.weight(2f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onClickTextStyle(style.copy(isBold = !style.isBold)) },
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = if (style.isBold) MaterialTheme.colorScheme.secondary else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(2.dp, Color.Transparent, shape = RoundedCornerShape(8.dp)),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.format_bold_24dp),
                    contentDescription = "Bold Icon",
                    modifier = Modifier.size(ICON_SIZE),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(
                onClick = { onClickTextStyle(style.copy(isItalic = !style.isItalic)) },
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = if (style.isItalic) MaterialTheme.colorScheme.secondary else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(2.dp, Color.Transparent, shape = RoundedCornerShape(8.dp)),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.format_italic_24dp),
                    contentDescription = "Italic Icon",
                    modifier = Modifier.size(ICON_SIZE),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(
                onClick = { onClickTextStyle(style.copy(isUnderline = !style.isUnderline)) },
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = if (style.isUnderline) MaterialTheme.colorScheme.secondary else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(2.dp, Color.Transparent, shape = RoundedCornerShape(8.dp)),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.format_underlined_24dp),
                    contentDescription = "UnderLine Icon",
                    modifier = Modifier.size(ICON_SIZE),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(
                onClick = { onClickTextStyle(style.copy(isStrikethrough = !style.isStrikethrough)) },
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = if (style.isStrikethrough) MaterialTheme.colorScheme.secondary else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(2.dp, Color.Transparent, shape = RoundedCornerShape(8.dp)),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.format_strikethrough_24dp),
                    contentDescription = "StrikeThrough Icon",
                    modifier = Modifier.size(ICON_SIZE),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Preview
@Composable
internal fun PreviewWriteTextStyle() {
    WriteTextStyle(
        style = TextStyle(),
        onClickTextStyle = {},
    )
}