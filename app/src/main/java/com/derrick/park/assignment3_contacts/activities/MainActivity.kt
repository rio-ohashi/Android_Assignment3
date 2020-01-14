package com.derrick.park.assignment3_contacts.activities

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.derrick.park.assignment3_contacts.R
import com.derrick.park.assignment3_contacts.models.ContactList
import com.derrick.park.assignment3_contacts.network.ContactClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView: RecyclerView = findViewById(R.id.contact_list)
        val contacts = ContactClient.getContacts(10)
        contacts.enqueue(object : Callback<ContactList> {
            override fun onResponse(call: Call<ContactList>, response: Response<ContactList>) {
                if (response.isSuccessful) {
                    recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                    recyclerView.adapter = ContactAdapter(response.body()!!.contactList!!)
                }
            }
            override fun onFailure(call: Call<ContactList>, t: Throwable) {
                println("error")
            }

        })

    }

    suspend fun setContacs(recyclerView: RecyclerView, num: Int) {
//        val contacts = ContactClient.getContacts(num)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = ContactAdapter(contacts!!)

    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}