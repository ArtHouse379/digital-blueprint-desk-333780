package automatedge.software.digitalblueprintdesk

import android.app.Application
import automatedge.software.digitalblueprintdesk.di.dataModule
import automatedge.software.digitalblueprintdesk.di.dispatcherModule
import automatedge.software.digitalblueprintdesk.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class EVWNKApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@EVWNKApplication)
            modules(appModules)
        }
    }
}
