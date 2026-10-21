package automatedge.software.digitalblueprintdesk.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BuildCircle
import androidx.compose.material.icons.outlined.VerifiedUser
import androidx.compose.material.icons.outlined.WorkspacePremium
import androidx.compose.ui.graphics.vector.ImageVector

data class Benefit(
    val icon: ImageVector,
    val text: String,
)

val defaultServiceBenefits: List<Benefit> = listOf(
    Benefit(icon = Icons.Outlined.WorkspacePremium, text = "Quality engineering"),
    Benefit(icon = Icons.Outlined.VerifiedUser, text = "Work warranty"),
    Benefit(icon = Icons.Outlined.BuildCircle, text = "Essential system care"),
)
