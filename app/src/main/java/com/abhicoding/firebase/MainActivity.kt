package com.abhicoding.firebase

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView : TextView = findViewById(R.id.text)
    /*    // Realtime Database Reference
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

        // Write  Data to Firebase
        database.child("Price").setValue("$1920")
        //  Reading data from Firebase
        val postListener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val price = snapshot.value
                textView.text = price.toString()
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.child("Price").addValueEventListener(postListener)


        // Initialize Firestore
        val db = Firebase.firestore

        // Creating a collection: "Users"
        val usersCollection = db.collection("Users")
        // Creating document
        val user1 = hashMapOf("name" to "Abhinandan","lastname" to "Verma","DOB" to "Nov 2005")
        val user2 = hashMapOf("name" to "Shivnandan","lastname" to "Verma","DOB" to "May 2008")
        // Adding data to Collection
        usersCollection.document("user1").set(user1)
        usersCollection.document("user2").set(user2)

        // Receive Documents from Firebase
        val docRef = db.collection("Users").document("user1")
        // Getting specific data from the collection
//        docRef.get().addOnSuccessListener {document->
//            if (document != null){
//                textView.text = "${document.data?.get("name")}"
//            }
//        }
        //  Getting All Documents from the Collection
        db.collection("Users").get().addOnSuccessListener {result ->
            for (document in result){
                Log.i("TAG","${document.data}")
                textView.append("${document.data}")
            }
        }
     */

    // Updating the Data in Document
        val db = Firebase.firestore

        db.collection("Users").document("user1")
           // .update("DOB","Nov 2005")
            .delete()
    }
}