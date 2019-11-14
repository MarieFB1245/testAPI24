package com.example.testapi24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.media.MediaPlayer
import android.widget.Toast
import com.example.testapi24.model.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_insert_data.*
import kotlinx.android.synthetic.main.activity_register_api.*
import kotlinx.android.synthetic.main.activity_register_api.password

class RegisterAPI : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_api)



        register.setOnClickListener{
            val email = email.text.toString()
            val password = password.text.toString()

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "create account  succeessfully!", Toast.LENGTH_SHORT).show()
                   writeNewUser()
                }else{
                    Toast.makeText(this, "create account not succeessfully!", Toast.LENGTH_SHORT).show()

                }
            }


        }
    }
    private fun writeNewUser() {

        val uid = FirebaseAuth.getInstance().uid?:""
        Log.d("pass","pass")
        val user1 = User(email.text.toString())
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")//.reference.child("users").child(userId).setValue(user1)


        ref.setValue(user1).addOnCompleteListener {
            Log.d("register","saved user to firebase")
        }

    }

    }




