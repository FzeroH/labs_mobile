package maksimov.ru.lab.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch
import maksimov.ru.lab.data.ContactsDB
import maksimov.ru.lab.data.entity.ContactsEntity

class SQLiteViewModel(application: Application) : AndroidViewModel(application) {


    var contactsLiveData : MutableLiveData<List<ContactsEntity>> = MutableLiveData()

    private val db = Room.databaseBuilder(application.applicationContext,
        ContactsDB::class.java,
        "Contacts").build()

    private val contactsDAO = db.contactsDao()

    fun getAllContacts(){
        viewModelScope.launch {
            contactsLiveData.postValue(contactsDAO.getAllContacts())
        }
    }

    fun addContact(uid:Int, name: String, email: String, phoneNumber: String): ContactsEntity {
        return ContactsEntity(
            uid = uid,
            name = name,
            email = email,
            phoneNumber = phoneNumber
        )
    }

}