package com.derrick.park.assignment3_contacts.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.derrick.park.assignment3_contacts.R
import com.derrick.park.assignment3_contacts.models.Contact
import com.derrick.park.assignment3_contacts.models.ContactList
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.contact_list_item.view.*
import java.util.ArrayList

class ContactAdapter(private val contacts: Array<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item, parent, false)
        return ContactHolder(itemView)
    }

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(contacts[position])
    }

    class ContactHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.contact_list.name
        private val tel: TextView = itemView.contact_list.tel

        fun bind(item:Contact) {
            name.text = item.name.toString()
            tel.text = item.cell
        }
    }
}
