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

/*    private class ContactsDatabaseCallback(
        private val scope:CoroutineScope
    ): RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.contactsDao())
                }
            }
        }
        suspend fun populateDatabase(contactsDao: ContactsDAO){
            contactsDao.deleteAll()
            val contact = ContactsEntity("89995554433","Игорь","aboba@mail.ru")
            contactsDao.addContact(contact)
        }
    }*/

    companion object{
        @Volatile
        private var INSTANCE: ContactsDB? = null

        fun getDatabase(context: Context, /*scope: CoroutineScope*/): ContactsDB{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactsDB::class.java,
                    "Contacts")
                    //.addCallback(ContactsDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}