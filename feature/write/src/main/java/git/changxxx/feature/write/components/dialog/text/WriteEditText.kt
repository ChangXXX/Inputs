package git.changxxx.feature.write.components.dialog.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import git.changxxx.feature.write.components.dialog.WriteBottomSheetState

@Composable
internal fun WriteEditText(
    text: String,
    fontSize: Int,
    fontStyle: List<WriteBottomSheetState.TextInput.TextStyle>,
    onTextChanged: (String) -> Unit,
) {
    val isBold = fontStyle.any { it is WriteBottomSheetState.TextInput.TextStyle.BOLD && it.isSelected }
    val isItalic = fontStyle.any { it is WriteBottomSheetState.TextInput.TextStyle.ITALIC && it.isSelected }
    val isUnderline = fontStyle.any { it is WriteBottomSheetState.TextInput.TextStyle.UNDERLINE && it.isSelected }
    val isStrikeThrough = fontStyle.any { it is WriteBottomSheetState.TextInput.TextStyle.STRIKETHROUGH && it.isSelected }

    OutlinedTextField(
        value = text,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = fontSize.sp,
            fontWeight = if (isBold) {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            },
            fontStyle = if (isItalic) {
                FontStyle.Italic
            } else {
                FontStyle.Normal
            },
            textDecoration = TextDecoration.combine(
                listOfNotNull(
                    if (isUnderline) TextDecoration.Underline else null,
                    if (isStrikeThrough) TextDecoration.LineThrough else null
                )
            )
        ),
        label = { Text("Enter your text") }
    )
}