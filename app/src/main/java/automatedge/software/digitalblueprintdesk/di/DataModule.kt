package automatedge.software.digitalblueprintdesk.di

import automatedge.software.digitalblueprintdesk.data.repository.BookingRepository
import automatedge.software.digitalblueprintdesk.data.repository.OnboardingRepository
import automatedge.software.digitalblueprintdesk.data.repository.ServiceRepository
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        OnboardingRepository(
            onboardingDataStoreManager = get(),
            coroutineDispatcher = get(DispatchersQualifiers.IO)
        )
    }

    single { ServiceRepository() }

    single {
        BookingRepository(
            bookingDao = get(),
            coroutineDispatcher = get(DispatchersQualifiers.IO)
        )
    }
}