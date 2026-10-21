package automatedge.software.digitalblueprintdesk.ui.composable.screen.servicedetails.includedlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import automatedge.software.digitalblueprintdesk.ui.theme.LocalDimens
import automatedge.software.digitalblueprintdesk.ui.theme.cardBorderStroke

private val BulletColumnSize = 16.dp
private val BulletDotSize = 6.dp

@Composable
fun ServiceIncludedItemsList(
    items: List<String>,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.cardPadding),
            verticalArrangement = Arrangement.spacedBy(dimens.tightSpacing),
        ) {
            items.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier.size(BulletColumnSize),
                        contentAlignment = Alignment.Center,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(BulletDotSize)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary),
                        )
                    }

                    Spacer(modifier = Modifier.width(dimens.itemSpacing))

                    Text(
                        text = item,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}
