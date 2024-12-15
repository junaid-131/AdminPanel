package com.example.adminpanel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adminpanel.databinding.ActivityAdminProfileBinding
import com.example.adminpanel.databinding.DeliveryItemBinding

class AdminProfileActivity : AppCompatActivity() {
    private val binding:ActivityAdminProfileBinding by lazy {
        ActivityAdminProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.name.isEnabled=false
        binding.email.isEnabled=false
        binding.phone.isEnabled=false
        binding.address.isEnabled=false
        binding.password.isEnabled=false

        var isEnable  =false
        binding.editprofile.setOnClickListener {
            isEnable = !isEnable
            binding.name.isEnabled=isEnable
            binding.email.isEnabled=isEnable
            binding.phone.isEnabled=isEnable
            binding.address.isEnabled=isEnable
            binding.password.isEnabled=isEnable

            if (isEnable){
                binding.name.requestFocus()
                Toast.makeText(this, "Edit your Profile", Toast.LENGTH_SHORT).show()
            }

        }

    }
}