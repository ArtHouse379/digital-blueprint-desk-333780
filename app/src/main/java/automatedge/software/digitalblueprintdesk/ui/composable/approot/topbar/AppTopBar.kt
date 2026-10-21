package automatedge.software.digitalblueprintdesk.ui.composable.approot.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import automatedge.software.digitalblueprintdesk.R
import automatedge.software.digitalblueprintdesk.ui.composable.approot.matchesAnyRoute
import automatedge.software.digitalblueprintdesk.ui.composable.approot.topbar.canNavigateBackRoutes
import automatedge.software.digitalblueprintdesk.ui.theme.ControlDivider
import automatedge.software.digitalblueprintdesk.ui.theme.LocalDimens
import automatedge.software.digitalblueprintdesk.ui.theme.StatusBarIconsFor

private val IconSize = 36.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    currentDestination: NavDestination?,
    onNavigateBack: () -> Unit,
) {
    val dimens = LocalDimens.current
    val canNavigateBack = currentDestination.matchesAnyRoute(canNavigateBackRoutes)
    val containerColor = MaterialTheme.colorScheme.surfaceContainer

    StatusBarIconsFor(containerColor)

    Column {
        TopAppBar(
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.icon),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(IconSize)
                            .clip(RoundedCornerShape(dimens.cornerRadius)),
                    )

                    Spacer(modifier = Modifier.width(dimens.itemSpacing))

                    Column {
                        Text(
                            text = stringResource(R.string.app_name),
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )

                        Text(
                            text = stringResource(R.string.splash_screen_tagline),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.labelSmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            },

            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_icon_description),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = containerColor,
                titleContentColor = MaterialTheme.colorScheme.onSurface,
                navigationIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            ),
        )

        ControlDivider()
    }
}
