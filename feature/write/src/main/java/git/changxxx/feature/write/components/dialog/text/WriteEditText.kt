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
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int,
    fontStyle: WriteBottomSheetState.TextInput.TextStyle,
    onTextChanged: (String) -> Unit,
) {
    OutlinedTextField(
        value = text,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = fontSize.sp,
            fontWeight = if (fontStyle.isBold) {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            },
            fontStyle = if (fontStyle.isItalic) {
                FontStyle.Italic
            } else {
                FontStyle.Normal
            },
            textDecoration = TextDecoration.combine(
                listOfNotNull(
                    if (fontStyle.isUnderline) TextDecoration.Underline else null,
                    if (fontStyle.isStrikethrough) TextDecoration.LineThrough else null
                )
            )
        ),
        label = { Text("Enter your text") }
    )
}