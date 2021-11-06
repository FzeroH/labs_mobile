package maksimov.ru.lab.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import maksimov.ru.lab.R
import maksimov.ru.lab.data.entity.ContactsEntity

class ListContactsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var contactsList : List<ContactsEntity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.list_contacts_element, parent, false)
        return ListContactsViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ListContactsViewHolder) {
            holder.bind(contacts = contactsList[position])
        }
    }

    override fun getItemCount(): Int {
        return contactsList.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newContactsList: List<ContactsEntity>){
        contactsList = newContactsList
        notifyDataSetChanged()
    }


}
class ListContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private  var mTxtName : TextView = itemView.findViewById(R.id.txt_name_element)
    private var mTxtEmail : TextView = itemView.findViewById(R.id.txt_email_element)
    private var mTxtPhone : TextView = itemView.findViewById(R.id.txt_phone_element)


    fun bind(contacts: ContactsEntity){
        contacts.apply{
            mTxtName.text = name
            mTxtEmail.text = email
            mTxtPhone.text = phoneNumber
        }
    }
}