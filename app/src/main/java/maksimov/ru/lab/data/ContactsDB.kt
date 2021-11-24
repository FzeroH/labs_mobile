package maksimov.ru.lab.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import maksimov.ru.lab.data.dao.ContactsDAO
import maksimov.ru.lab.data.entity.ContactsEntity

@Database(entities = [ContactsEntity::class], version = 1, exportSchema = false)
abstract class ContactsDB: RoomDatabase() {
    abstract fun contactsDao(): ContactsDAO

    companion object{
        @Volatile
        private var INSTANCE: ContactsDB? = null

        fun getDatabase(context: Context): ContactsDB{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactsDB::class.java,
                    "Contacts")
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}