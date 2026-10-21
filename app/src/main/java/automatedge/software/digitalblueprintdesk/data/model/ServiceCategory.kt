package automatedge.software.digitalblueprintdesk.data.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BusinessCenter
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.material.icons.outlined.SupportAgent
import androidx.compose.material.icons.outlined.TipsAndUpdates
import androidx.compose.ui.graphics.vector.ImageVector
import automatedge.software.digitalblueprintdesk.R

enum class ServiceCategory(
    @field:StringRes val titleRes: Int,
    val icon: ImageVector,
) {
    BUSINESS_SOFTWARE(R.string.service_category_business_software_title, Icons.Outlined.BusinessCenter),
    CONSUMER_APPS(R.string.service_category_consumer_apps_title, Icons.Outlined.PhoneAndroid),
    IT_CONSULTING(R.string.service_category_it_consulting_title, Icons.Outlined.TipsAndUpdates),
    CLOUD_SYSTEMS(R.string.service_category_cloud_systems_title, Icons.Outlined.Cloud),
    DIGITAL_SUPPORT(R.string.service_category_digital_support_title, Icons.Outlined.SupportAgent),
}
