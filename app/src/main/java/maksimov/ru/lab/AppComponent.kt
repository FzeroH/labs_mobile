package maksimov.ru.lab

import android.app.Application
import androidx.room.Room
import dagger.Component
import dagger.Module
import dagger.Provides
import maksimov.ru.lab.data.ContactsDB

@Component(modules = [DatabaseModule::class])
interface AppComponent {

    val dataBase: ContactsDB
}
@Module
object DatabaseModule{
    @Provides
    fun provideRoomDataBase(application: Application): ContactsDB {
        return Room.databaseBuilder(
            application.applicationContext,
            ContactsDB::class.java,
            "Contacts").build()
    }
}