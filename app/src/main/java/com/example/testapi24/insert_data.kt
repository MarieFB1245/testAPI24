package com.example.testapi24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.database.*





class insert_data : AppCompatActivity() {

    private lateinit var myRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)
        myRef = FirebaseDatabase.getInstance().reference

    }


    fun insert(v:View) {

        val iduser = findViewById(R.id.iduser) as TextView
        val idpassword = findViewById(R.id.idpassword) as TextView

        myRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val map = dataSnapshot.value as Map<*, *>?
                val map1 = dataSnapshot.child("testuser").value as Map<*, *>?
                val user = map1!!["username"].toString()
                val password = map1["password"].toString()
                iduser.text = user
                idpassword.text = password
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }
}
