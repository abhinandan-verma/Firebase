package com.abhicoding.firebase

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView : TextView = findViewById(R.id.text)
        // Realtime Database Reference
        database = Firebase.database.reference
        // Writing custom objects to firebase
        val user1 = User("Abhinandan","12345678")
        database.child("Users").setValue(user1)

        // Reading custom objects from firebase
        val pe = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
              val u1  = snapshot.getValue<User>()
                textView.text = u1.toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        }
        database.child("Users").addValueEventListener(pe)

//        // Write  Data to Firebase
//        database.child("Price").setValue("$1920")
//        //  Reading data from Firebase
//        val postListener = object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val price = snapshot.value
//                textView.text = price.toString()
//            }
//            override fun onCancelled(error: DatabaseError) {
//            }
//        }
//        database.child("Price").addValueEventListener(postListener)
    }
}