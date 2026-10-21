package automatedge.software.digitalblueprintdesk.di

import androidx.room.Room
import automatedge.software.digitalblueprintdesk.data.database.Database
import org.koin.dsl.module

private const val DB_NAME = "evwnk_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = Database::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<Database>().bookingDao() }
}