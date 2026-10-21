package automatedge.software.digitalblueprintdesk.ui.composable.screen.home.filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import automatedge.software.digitalblueprintdesk.R
import automatedge.software.digitalblueprintdesk.data.model.ServiceCategory
import automatedge.software.digitalblueprintdesk.ui.theme.ControlDivider
import automatedge.software.digitalblueprintdesk.ui.theme.LocalDimens

@Composable
fun CategoryFilterRow(
    selectedCategory: ServiceCategory?,
    modifier: Modifier = Modifier,
    onCategoryClick: (ServiceCategory?) -> Unit,
) {
    val dimens = LocalDimens.current

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surfaceContainer,
    ) {
        Column {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(
                    horizontal = dimens.screenPadding,
                    vertical = dimens.contentSpacing,
                ),
                horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing),
            ) {
                item {
                    CategoryChip(
                        isSelected = selectedCategory == null,
                        title = stringResource(R.string.home_filter_all),
                        onClick = { onCategoryClick(null) },
                    )
                }

                items(items = ServiceCategory.entries) { category ->
                    CategoryChip(
                        isSelected = selectedCategory == category,
                        title = stringResource(category.titleRes),
                        onClick = { onCategoryClick(category) },
                    )
                }
            }

            ControlDivider()
        }
    }
}

@Composable
private fun CategoryChip(
    isSelected: Boolean,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val dimens = LocalDimens.current

    FilterChip(
        selected = isSelected,
        onClick = onClick,
        label = { Text(text = title) },
        modifier = modifier,
        shape = RoundedCornerShape(dimens.controlCornerRadius),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            labelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            selectedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = isSelected,
            borderColor = MaterialTheme.colorScheme.outlineVariant,
            selectedBorderColor = MaterialTheme.colorScheme.secondary,
            borderWidth = dimens.controlBorderWidth,
            selectedBorderWidth = dimens.controlBorderWidth,
        ),
    )
}
