package com.example.adminpanel

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminpanel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.addmenu.setOnClickListener{
            startActivity(Intent(this,AddItemActivity::class.java))
        }
        binding.allmenuitem.setOnClickListener {
            startActivity(Intent(this,AllItemActivity::class.java))
        }
        binding.outForDelivery.setOnClickListener {
            startActivity(Intent(this,OutforDeliveryActivity::class.java))
        }
        binding.profile.setOnClickListener {
            startActivity(Intent(this,AdminProfileActivity::class.java))
        }
        binding.createuser.setOnClickListener {
            startActivity(Intent(this,CreateUserActivity::class.java))
        }
        binding.textView8.setOnClickListener {
            startActivity(Intent(this,PendingOrderActivity::class.java))
        }

    }
}