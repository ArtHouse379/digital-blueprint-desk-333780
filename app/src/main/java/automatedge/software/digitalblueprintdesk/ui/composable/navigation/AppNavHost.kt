package automatedge.software.digitalblueprintdesk.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import automatedge.software.digitalblueprintdesk.ui.composable.screen.bookings.EVWNKBookingsScreen
import automatedge.software.digitalblueprintdesk.ui.composable.screen.checkout.EVWNKCheckoutScreen
import automatedge.software.digitalblueprintdesk.ui.composable.screen.home.EVWNKHomeScreen
import automatedge.software.digitalblueprintdesk.ui.composable.screen.onboarding.EVWNKOnboardingScreen
import automatedge.software.digitalblueprintdesk.ui.composable.screen.servicedetails.EVWNKServiceDetailsScreen
import automatedge.software.digitalblueprintdesk.ui.composable.screen.settings.EVWNKSettingsScreen
import automatedge.software.digitalblueprintdesk.ui.composable.screen.splash.EVWNKSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            EVWNKSplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            EVWNKOnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            EVWNKHomeScreen(
                onNavigateToServiceDetails = { serviceId: Int ->
                    navController.navigate(
                        route = NavRoute.ServiceDetails(serviceId = serviceId)
                    )
                }
            )
        }

        composable<NavRoute.ServiceDetails> { backStackEntry ->
            val serviceDetails: NavRoute.ServiceDetails = backStackEntry.toRoute()
            EVWNKServiceDetailsScreen(
                serviceId = serviceDetails.serviceId,
                onNavigateToCheckout = { serviceId: Int ->
                    navController.navigate(
                        route = NavRoute.Checkout(serviceId = serviceId)
                    )
                }
            )
        }

        composable<NavRoute.Checkout> { backStackEntry ->
            val checkout: NavRoute.Checkout = backStackEntry.toRoute()
            EVWNKCheckoutScreen(
                serviceId = checkout.serviceId,
                onNavigateToBookingsScreen = {
                    navController.navigate(NavRoute.Bookings) {
                        popUpTo(NavRoute.Home) {
                            inclusive = false
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Bookings> {
            EVWNKBookingsScreen()
        }

        composable<NavRoute.Settings> {
            EVWNKSettingsScreen()
        }
    }
}