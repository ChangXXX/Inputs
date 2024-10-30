package git.changxxx.inputs.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import git.changxxx.core.designsystem.theme.InputsTheme

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()

        setContent {
            InputsTheme {
                MainScreen()
            }
        }
    }
}