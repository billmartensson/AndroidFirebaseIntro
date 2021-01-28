package se.magictechnology.firebaseintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        //val myRef = database.getReference("message")

        //myRef.setValue("Hello, something else!")

        /*
        val ourListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val ourText = dataSnapshot.getValue() as String
                // ...
                Log.i("PIA9DEBUG", ourText)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("PIA9DEBUG", "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        }
        myRef.addListenerForSingleValueEvent(ourListener)
        */



        val myOtherRef = database.getReference("otherAndroid")

        //myOtherRef.push().child("fruit").setValue("banana")

        myOtherRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (ourSnapshot in dataSnapshot.children) {
                    // TODO: handle the post
                    Log.i("PIA9DEBUG", ourSnapshot.child("fruit").value as String)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("PIA9DEBUG", "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        })

    }
}