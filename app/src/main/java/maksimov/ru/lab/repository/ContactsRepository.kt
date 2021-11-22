package maksimov.ru.lab.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import maksimov.ru.lab.data.dao.ContactsDAO
import maksimov.ru.lab.data.entity.ContactsEntity

class ContactsRepository(private val contactsDao: ContactsDAO) {

    val getAllContacts: Flow<List<ContactsEntity>> = contactsDao.getAllContacts()

    @WorkerThread
    suspend fun addContact(contact: ContactsEntity){
        contactsDao.addContact(contact)
    }

    @WorkerThread
    suspend fun deleteAllContacts(){
        contactsDao.deleteAll()
    }

}