package maksimov.ru.lab

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import maksimov.ru.lab.data.ContactsDB
import maksimov.ru.lab.repository.ContactsRepository

class App: Application() {
    //val applicationScope = CoroutineScope(SupervisorJob())

    val db by lazy {ContactsDB.getDatabase(this@App, /*applicationScope*/) }
    val repository by lazy {ContactsRepository(db.contactsDao())}
}