package com.example.adminpanel

import android.R.attr.password
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminpanel.Adapter.models.userModel
import com.example.adminpanel.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {
    private lateinit var username: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var nameofResturant: String
    private lateinit var location: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private val binding:ActivitySignupBinding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val arraylist = arrayOf("lahore","multan","karachi","islamabad")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arraylist)
        val autoCompleteTextView = binding.ListofLocation
        autoCompleteTextView.setAdapter(adapter)

        binding.alreadyHaveAccount.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference()


        binding.createAccount.setOnClickListener {task->
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                createuser(email,password)
        }
            else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }

    }
}

    private fun createuser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {

                saveruserdata()
                Toast.makeText(this, "Authentication successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Authentication failed ${task.exception}", Toast.LENGTH_SHORT).show()
                Log.d("Account", task.exception.toString())
            }


        }


    }
    private fun saveruserdata() {
        email = binding.email.text.toString()
        password = binding.password.text.toString()
        username = binding.username.text.toString()
        nameofResturant = binding.nameofResturant.text.toString()
        location = binding.ListofLocation.text.toString()

        val user = userModel(email,password,username,nameofResturant,location)
        val uid = FirebaseAuth.getInstance().currentUser!!.uid
        database.child("users").child(uid).setValue(user)

    }


}


