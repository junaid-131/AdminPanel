package com.example.adminpanel

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminpanel.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
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

    }
}