package automatedge.software.digitalblueprintdesk.data.repository

import automatedge.software.digitalblueprintdesk.data.model.ServiceCategory
import automatedge.software.digitalblueprintdesk.data.model.ServiceModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ServiceRepository {
    private val services: List<ServiceModel> = listOf(
        ServiceModel(
            id = 1,
            name = "Business software development",
            description = "We build tailored software that streamlines daily operations and connects essential business data. The work begins with process mapping and a practical technical plan. Delivery includes tested code, clear handover notes, and guidance for future improvements.",
            serviceCategory = ServiceCategory.BUSINESS_SOFTWARE,
            pricePerHour = 95.0,
            imageUrl = "https://images.unsplash.com/photo-1580894894513-541e068a3e2b",
            includedItems = listOf("Requirements review", "Custom development", "Testing and handover"),
        ),
        ServiceModel(
            id = 2,
            name = "E-commerce website development",
            description = "We develop an online shop around your products, customers, and fulfilment workflow. The service covers responsive storefront pages, secure checkout integration, and essential store administration. We test the main purchase journey before launch and provide straightforward operating guidance.",
            serviceCategory = ServiceCategory.BUSINESS_SOFTWARE,
            pricePerHour = 85.0,
            imageUrl = "https://images.unsplash.com/photo-1534665482403-a909d0d97c67",
            includedItems = listOf("Storefront build", "Checkout integration", "Launch testing"),
        ),
        ServiceModel(
            id = 3,
            name = "Mobile app development",
            description = "We create mobile applications with clear navigation and reliable performance on everyday devices. Each project includes interface planning, feature implementation, and testing across suitable screen sizes. The finished app is prepared for deployment with maintainable code and concise documentation.",
            serviceCategory = ServiceCategory.CONSUMER_APPS,
            pricePerHour = 90.0,
            imageUrl = "https://images.unsplash.com/photo-1778146448308-149ff6244135",
            includedItems = listOf("Interface planning", "App development", "Device testing"),
        ),
        ServiceModel(
            id = 4,
            name = "Desktop application development",
            description = "We build desktop applications for focused workflows that need speed, privacy, or offline access. The solution is designed around the target operating environment and the people who will use it. We deliver tested functionality, installation guidance, and a maintainable project structure.",
            serviceCategory = ServiceCategory.CONSUMER_APPS,
            pricePerHour = 80.0,
            imageUrl = "https://images.unsplash.com/photo-1744555270794-6d378b9e7cd3",
            includedItems = listOf("Workflow design", "Desktop build", "Installation guide"),
        ),
        ServiceModel(
            id = 5,
            name = "IT strategy consulting",
            description = "We review your current technology, business goals, and operational constraints. You receive a prioritised roadmap that separates urgent improvements from longer-term investments. Recommendations are practical, vendor-neutral, and explained in language decision-makers can use.",
            serviceCategory = ServiceCategory.IT_CONSULTING,
            pricePerHour = 125.0,
            imageUrl = "https://images.unsplash.com/photo-1517245386807-bb43f82c33c4",
            includedItems = listOf("Technology review", "Priority roadmap", "Decision briefing"),
        ),
        ServiceModel(
            id = 6,
            name = "Cybersecurity assessment",
            description = "We examine key systems, access controls, and working practices for common security weaknesses. Findings are ranked by risk so your team can address the most important issues first. The assessment concludes with clear remediation actions and a review call.",
            serviceCategory = ServiceCategory.IT_CONSULTING,
            pricePerHour = 110.0,
            imageUrl = "https://images.unsplash.com/photo-1549692520-acc6669e2f0c",
            includedItems = listOf("Risk review", "Security findings", "Remediation plan"),
        ),
        ServiceModel(
            id = 7,
            name = "Cloud migration",
            description = "We move selected applications and data to a suitable cloud environment with minimal disruption. The migration plan covers dependencies, access, backups, and a safe transition sequence. After validation, we document the new setup and explain routine management tasks.",
            serviceCategory = ServiceCategory.CLOUD_SYSTEMS,
            pricePerHour = 115.0,
            imageUrl = "https://images.unsplash.com/photo-1629904853893-c2c8981a1dc5",
            includedItems = listOf("Migration planning", "Data transfer", "Post-move validation"),
        ),
        ServiceModel(
            id = 8,
            name = "Server setup",
            description = "We configure a secure server environment for websites, applications, or internal services. Setup includes operating system hardening, user access, monitoring, and a tested backup approach. You receive the essential configuration record and instructions for ongoing administration.",
            serviceCategory = ServiceCategory.CLOUD_SYSTEMS,
            pricePerHour = 100.0,
            imageUrl = "https://images.pexels.com/photos/442150/pexels-photo-442150.jpeg",
            includedItems = listOf("Secure configuration", "Monitoring setup", "Backup testing"),
        ),
        ServiceModel(
            id = 9,
            name = "Network troubleshooting",
            description = "We investigate slow, unstable, or unavailable network connections across your workplace systems. Testing isolates faults in devices, configuration, cabling, or internet access. We restore reliable connectivity where possible and leave clear recommendations for any required upgrades.",
            serviceCategory = ServiceCategory.DIGITAL_SUPPORT,
            pricePerHour = 75.0,
            imageUrl = "https://images.pexels.com/photos/442151/pexels-photo-442151.jpeg",
            includedItems = listOf("Connection testing", "Fault isolation", "Fix recommendations"),
        ),
        ServiceModel(
            id = 10,
            name = "Software maintenance",
            description = "We keep existing software stable through targeted fixes, dependency updates, and routine technical review. Changes are assessed for risk and tested before release to protect current workflows. You receive a concise record of completed work and any issues that need future attention.",
            serviceCategory = ServiceCategory.DIGITAL_SUPPORT,
            pricePerHour = 70.0,
            imageUrl = "https://images.unsplash.com/photo-1753998943918-dd2dfc4ee6ed",
            includedItems = listOf("Issue diagnosis", "Code updates", "Release checks"),
        ),
    )

    fun observeAll(): Flow<List<ServiceModel>> {
        return flowOf(services)
    }

    fun observeById(id: Int): Flow<ServiceModel?> {
        val service = services.firstOrNull { service -> service.id == id }
        return flowOf(service)
    }

    fun getById(id: Int): ServiceModel? {
        return services.firstOrNull { service -> service.id == id }
    }
}
