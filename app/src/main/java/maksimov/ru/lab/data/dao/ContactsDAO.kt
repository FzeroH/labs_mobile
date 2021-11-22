package maksimov.ru.lab.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import maksimov.ru.lab.data.entity.ContactsEntity

@Dao
interface ContactsDAO {

    @Query("SELECT * FROM Contacts")
    fun getAllContacts(): Flow<List<ContactsEntity>>
    
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContact(contact: ContactsEntity)

    @Query("DELETE FROM Contacts")
    suspend fun deleteAll()
}