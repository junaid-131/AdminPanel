package com.example.adminpanel

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminpanel.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding:ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.dontHaveAccount.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
        binding.LoginBtn.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}