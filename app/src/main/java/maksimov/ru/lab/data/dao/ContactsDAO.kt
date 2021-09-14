package maksimov.ru.lab.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import maksimov.ru.lab.data.entity.ContactsEntity

@Dao
interface ContactsDAO {

    @Query("SELECT * FROM Contacts")
    fun getAllContacts(): List<ContactsEntity>

    @Insert
    fun addContact(contact: ContactsEntity)

    @Delete
    fun deleteContacts(contact: ContactsEntity)

}