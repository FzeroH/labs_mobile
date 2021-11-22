package maksimov.ru.lab.viewmodel

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import maksimov.ru.lab.data.entity.ContactsEntity
import maksimov.ru.lab.repository.ContactsRepository

class ContactsViewModel(private val repository: ContactsRepository): ViewModel() {


    var contactsLiveData : LiveData<List<ContactsEntity>> = repository.getAllContacts.asLiveData()

    fun addContact(contact: ContactsEntity) {
        try{
            viewModelScope.launch {
                repository.addContact(contact)
            }
        }
        catch(e: Exception){
            Log.d("EXCEPTION", "Warning ${e.message}")
        }
    }
    fun deleteContact() {
        try{
            viewModelScope.launch {
                repository.deleteAllContacts()
            }
        }
        catch(e: Exception){
            Log.d("EXCEPTION", "Warning ${e.message}")
        }
    }

}

class ViewModelFactory(private val repository:ContactsRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContactsViewModel::class.java)){
            return ContactsViewModel(repository) as T
        }
        else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}