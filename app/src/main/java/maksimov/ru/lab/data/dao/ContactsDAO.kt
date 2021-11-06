package maksimov.ru.lab.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import maksimov.ru.lab.data.entity.ContactsEntity

@Dao
interface ContactsDAO {

    @Query("SELECT * FROM Contacts")
    suspend fun getAllContacts(): List<ContactsEntity>

    @Insert
    suspend fun addContact(contact: ContactsEntity)
}