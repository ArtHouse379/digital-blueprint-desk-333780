package automatedge.software.digitalblueprintdesk.ui.composable.screen.servicedetails.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import automatedge.software.digitalblueprintdesk.ui.composable.screen.shared.ServiceImage
import automatedge.software.digitalblueprintdesk.ui.theme.LocalDimens
import automatedge.software.digitalblueprintdesk.ui.theme.imageBorder

private const val ImageAspectRatio = 4f / 3f
private const val TintAlpha = 0.10f

@Composable
fun ServiceDetailsImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val shape = RoundedCornerShape(dimens.cardCornerRadius)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(ImageAspectRatio)
            .clip(shape)
            .imageBorder(shape),
    ) {
        ServiceImage(
            imageUrl = imageUrl,
            modifier = Modifier.fillMaxSize(),
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary.copy(alpha = TintAlpha)),
        )
    }
}
