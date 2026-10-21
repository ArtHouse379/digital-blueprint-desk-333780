package automatedge.software.digitalblueprintdesk.di

import automatedge.software.digitalblueprintdesk.ui.viewmodel.BookingViewModel
import automatedge.software.digitalblueprintdesk.ui.viewmodel.CheckoutViewModel
import automatedge.software.digitalblueprintdesk.ui.viewmodel.OnboardingViewModel
import automatedge.software.digitalblueprintdesk.ui.viewmodel.ServiceDetailsViewModel
import automatedge.software.digitalblueprintdesk.ui.viewmodel.ServiceViewModel
import automatedge.software.digitalblueprintdesk.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ServiceViewModel(
            serviceRepository = get()
        )
    }

    viewModel {
        ServiceDetailsViewModel(
            serviceRepository = get()
        )
    }

    viewModel {
        BookingViewModel(
            bookingRepository = get(),
            serviceRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            bookingRepository = get(),
        )
    }
}