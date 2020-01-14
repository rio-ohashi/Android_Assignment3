package com.derrick.park.assignment3_contacts.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Contact(
    val name: Name? =null,
    val email: String?,
    val cell: String? = null){

    /**
     * Name {first: , last: }
     */
    inner class Name {
        @Expose
        val first: String? = null
        @Expose
        val last: String? = null

        override fun toString(): String {
            return "$first $last"
        }
    }
}