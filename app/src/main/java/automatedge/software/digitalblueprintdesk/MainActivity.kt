package automatedge.software.digitalblueprintdesk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import automatedge.software.digitalblueprintdesk.ui.composable.approot.AppRoot
import automatedge.software.digitalblueprintdesk.ui.theme.EVWNKAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EVWNKAppTheme {
                AppRoot()
            }
        }
    }
}