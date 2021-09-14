package maksimov.ru.lab.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class ContactsEntity(
    @PrimaryKey(autoGenerate = true) val uid: UInt,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Email") val email: String,
    @ColumnInfo(name = "PhoneNumber") val phoneNumber: String
)