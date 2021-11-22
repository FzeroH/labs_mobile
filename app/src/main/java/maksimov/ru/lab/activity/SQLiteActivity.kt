package maksimov.ru.lab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import maksimov.ru.lab.App
import maksimov.ru.lab.R
import maksimov.ru.lab.adapter.ListContactsAdapter
import maksimov.ru.lab.data.entity.ContactsEntity
import maksimov.ru.lab.viewmodel.ContactsViewModel
import maksimov.ru.lab.viewmodel.ViewModelFactory

class SQLiteActivity : AppCompatActivity() {

    private lateinit var mName: EditText
    private lateinit var mEmail: EditText
    private lateinit var mPhone: EditText
    private val adapter = ListContactsAdapter()
    private val contactsViewModel:ContactsViewModel by viewModels {
        ViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val listContacts: RecyclerView = findViewById(R.id.list_contacts)
        listContacts.adapter = adapter
        listContacts.layoutManager = LinearLayoutManager(this)

        mName = findViewById(R.id.name)
        mEmail = findViewById(R.id.email)
        mPhone = findViewById(R.id.phone_number)
        val mAddButton: Button = findViewById(R.id.add_button)
        mAddButton.setOnClickListener{
            addContact()
            getAllContacts(this)
        }
        val mDeleteButton: Button = findViewById(R.id.delete_button)
        mDeleteButton.setOnClickListener{
            contactsViewModel.deleteContact()
            Toast.makeText(this,"Данные из базы удалены", LENGTH_SHORT).show()
            getAllContacts(this)
        }
        getAllContacts(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        contactsViewModel.contactsLiveData.removeObservers(this)
    }

    private fun addContact() {
        val contact = ContactsEntity(
            mPhone.text.toString(),
            mName.text.toString(),
            mEmail.text.toString()
        )
        if (mPhone.text.toString() == "" || mName.text.toString() == "" || mEmail.text.toString() == ""){
            Toast.makeText(this,"Заполните все поля", LENGTH_SHORT).show()
        }else {
            contactsViewModel.addContact(contact)
            mName.text.clear()
            mEmail.text.clear()
            mPhone.text.clear()
        }
    }

    private fun getAllContacts(owner: LifecycleOwner){
        contactsViewModel.contactsLiveData.observe(owner){ contact ->
            contact.let{adapter.setData(it)}
        }
    }
}