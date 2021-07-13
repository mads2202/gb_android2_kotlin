package com.mads2202.gb_android2_kotlin


import android.app.Activity
import android.content.ContentUris
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.ImageView
import java.io.IOException
import java.io.InputStream


class MyActivity() : Activity() {
    private var uriContact: Uri? = null
    private var contactID // contacts unique ID
            : String? = null

    /**
     * Called when the activity is first created.
     */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickSelectContact(btnSelectContact: View?) {

        // using native contacts selection
        // Intent.ACTION_PICK = Pick an item from the data, returning what was selected.
        startActivityForResult(
            Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI),
            REQUEST_CODE_PICK_CONTACTS
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICK_CONTACTS && resultCode == RESULT_OK) {
            Log.d(TAG, "Response: $data")
            uriContact = data.data
            retrieveContactName()
            retrieveContactNumber()
        }
    }

    private fun retrieveContactNumber() {
        var contactNumber: String? = null

        // getting contacts ID
        val cursorID: Cursor? = uriContact?.let {
            contentResolver.query(
                it, arrayOf(ContactsContract.Contacts._ID),
                null, null, null
            )
        }
        cursorID?.let {
            if (it.moveToFirst()) {
                contactID = it.getString(it.getColumnIndex(ContactsContract.Contacts._ID))
            }
            it.close()
        }

        Log.d(TAG, "Contact ID: $contactID")

        // Using the contact ID now we will get contact phone number
        val cursorPhone: Cursor? = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER),
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? AND " +
                    ContactsContract.CommonDataKinds.Phone.TYPE + " = " +
                    ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,
            arrayOf(contactID),
            null
        )
        cursorPhone?.let {
            if (it.moveToFirst()) {
                contactNumber =
                    it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            }
            it.close()
        }

        Log.d(TAG, "Contact Phone Number: $contactNumber")
    }

    private fun retrieveContactName() {
        var contactName: String? = null

        // querying contact data store
        val cursor: Cursor? = uriContact?.let { contentResolver.query(it, null, null, null, null) }
        cursor?.let {
            if (it.moveToFirst()) {

                // DISPLAY_NAME = The display name for the contact.
                // HAS_PHONE_NUMBER =   An indicator of whether this contact has at least one phone number.
                contactName =
                    it.getString(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
            }
            it.close()
        }
        Log.d(TAG, "Contact Name: $contactName")
    }

    companion object {
        private val TAG = MyActivity::class.java.simpleName
        private val REQUEST_CODE_PICK_CONTACTS = 1
    }
}