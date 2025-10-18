package com.example.adminpanel

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminpanel.Adapter.models.userModel
import com.example.adminpanel.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var email: String
    private  var username: String?=null
    private  var nameofResturant: String?=null
    private  var location: String? =null
    private var password: String?=null
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.dontHaveAccount.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference()

        binding.LoginBtn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (email.isEmpty() or password.isEmpty()) {
                Toast.makeText(this, "fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                login(email, password)


            }


        }

    }

    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
              val user = auth.currentUser
                updateUI(user)
                saveuserdata()
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

            }
            else{
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                    val user = auth.currentUser
                    updateUI(user)
                    saveuserdata()
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
    private fun updateUI(user: FirebaseUser?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun saveuserdata() {
        email = binding.email.text.toString()
        password = binding.password.text.toString()
        

        val user = userModel(email,password,username,nameofResturant,location)
        val uid = FirebaseAuth.getInstance().currentUser!!.uid
        uid.let {
            database.child("users").child(it).setValue(user)
        }
    }
}