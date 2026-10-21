package automatedge.software.digitalblueprintdesk.ui.composable.screen.onboarding.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import automatedge.software.digitalblueprintdesk.ui.theme.LocalDimens
import automatedge.software.digitalblueprintdesk.ui.theme.imageBorder

private val BackdropSize = 140.dp
private val IconSize = 56.dp

@Composable
fun OnboardingIcon(
    icons: List<ImageVector>,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val shape = RoundedCornerShape(dimens.cornerRadius)

    Box(
        modifier = modifier
            .size(BackdropSize)
            .clip(shape)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .imageBorder(shape),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = icons.last(),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.size(IconSize),
        )
    }
}
