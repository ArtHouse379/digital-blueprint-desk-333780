package automatedge.software.digitalblueprintdesk.ui.composable.screen.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import automatedge.software.digitalblueprintdesk.ui.composable.approot.LocalContentBottomPadding
import automatedge.software.digitalblueprintdesk.ui.composable.screen.settings.card.AppInfoCard
import automatedge.software.digitalblueprintdesk.ui.theme.LocalDimens

@Composable
fun EVWNKSettingsScreen(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimens.screenPadding)
            .padding(bottom = LocalContentBottomPadding.current),
    ) {
        AppInfoCard()
    }
}
