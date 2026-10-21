package automatedge.software.digitalblueprintdesk.ui.composable.screen.servicedetails.summary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import automatedge.software.digitalblueprintdesk.R
import automatedge.software.digitalblueprintdesk.data.model.ServiceModel
import automatedge.software.digitalblueprintdesk.ui.theme.LocalDimens

@Composable
fun ServiceSummary(
    service: ServiceModel,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Column(modifier = modifier) {
        Text(
            text = stringResource(service.serviceCategory.titleRes).uppercase(),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 1.5.sp),
        )

        Spacer(modifier = Modifier.height(dimens.tightSpacing))

        Text(
            text = service.name,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium,
        )

        Spacer(modifier = Modifier.height(dimens.itemSpacing))

        Text(
            text = stringResource(R.string.price_per_hour, service.pricePerHour),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}
