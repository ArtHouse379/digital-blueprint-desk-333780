package automatedge.software.digitalblueprintdesk.ui.composable.screen.settings.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.OpenInNew
import androidx.compose.material.icons.outlined.SupportAgent
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import automatedge.software.digitalblueprintdesk.R
import automatedge.software.digitalblueprintdesk.ui.theme.ControlDivider
import automatedge.software.digitalblueprintdesk.ui.theme.LocalDimens
import automatedge.software.digitalblueprintdesk.ui.theme.cardBorderStroke

private val TrailingIconSize = 20.dp

@Composable
fun AppInfoCard(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current
    val companyName = stringResource(R.string.evwnk_company_name)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimens.sectionGap),
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(dimens.cardCornerRadius),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
                contentColor = MaterialTheme.colorScheme.onSurface,
            ),
            border = cardBorderStroke(),
        ) {
            Column(modifier = Modifier.padding(dimens.cardPadding)) {
                Text(
                    text = stringResource(R.string.app_name),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.headlineSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = stringResource(R.string.settings_screen_app_label),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.labelMedium,
                )

                Spacer(modifier = Modifier.height(dimens.contentSpacing))

                ControlDivider()

                Spacer(modifier = Modifier.height(dimens.contentSpacing))

                if (companyName.isNotBlank()) {
                    MetaRow(
                        label = stringResource(R.string.settings_screen_company_label),
                        value = companyName,
                    )

                    Spacer(modifier = Modifier.height(dimens.tightSpacing))
                }

                MetaRow(
                    label = stringResource(R.string.settings_screen_version_label),
                    value = stringResource(R.string.evwnk_app_version),
                )
            }
        }

        CustomerSupportCard(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun CustomerSupportCard(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current
    val supportLink = stringResource(R.string.evwnk_customer_support_link)

    if (supportLink.isBlank()) return

    val uriHandler = LocalUriHandler.current

    Card(
        onClick = { uriHandler.openUri(supportLink) },
        modifier = modifier,
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.cardPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
        ) {
            Icon(
                imageVector = Icons.Outlined.SupportAgent,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )

            MetaRow(
                modifier = Modifier.weight(1f),
                label = stringResource(R.string.settings_screen_customer_support_label),
                value = supportLink,
                valueColor = MaterialTheme.colorScheme.primary,
            )

            Icon(
                imageVector = Icons.AutoMirrored.Outlined.OpenInNew,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(TrailingIconSize),
            )
        }
    }
}

@Composable
private fun MetaRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    valueColor: Color = MaterialTheme.colorScheme.onSurface,
    valueModifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(LocalDimens.current.contentSpacing),
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )

        Text(
            text = value,
            modifier = valueModifier.weight(1f),
            color = valueColor,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.End,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
