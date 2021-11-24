package maksimov.ru.lab

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import maksimov.ru.lab.data.ContactsDB
import maksimov.ru.lab.repository.ContactsRepository

class App: Application() {

    val db by lazy {ContactsDB.getDatabase(this@App) }
    val repository by lazy {ContactsRepository(db.contactsDao())}
}