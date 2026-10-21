package automatedge.software.digitalblueprintdesk.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import automatedge.software.digitalblueprintdesk.data.dao.BookingDao
import automatedge.software.digitalblueprintdesk.data.database.converter.Converters
import automatedge.software.digitalblueprintdesk.data.entity.BookingEntity

@Database(
    entities = [BookingEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {

    abstract fun bookingDao(): BookingDao
}

