package maksimov.ru.lab.data

import androidx.room.Database
import androidx.room.RoomDatabase
import maksimov.ru.lab.data.dao.ContactsDAO
import maksimov.ru.lab.data.entity.ContactsEntity

@Database(entities = [ContactsEntity::class], version = 1)
abstract class ContactsDB: RoomDatabase() {
    abstract fun contactsDao(): ContactsDAO

}