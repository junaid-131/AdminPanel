package com.example.adminpanel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminpanel.Adapter.DeliveryAdapter
import com.example.adminpanel.databinding.ActivityOutforDeliveryBinding

class OutforDeliveryActivity : AppCompatActivity() {
    private val binding:ActivityOutforDeliveryBinding by lazy {
        ActivityOutforDeliveryBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.backButton.setOnClickListener {finish()}

        val customername = listOf("john","mickel","ali","hassan")
        val moneystatus = listOf("received","pending","received","notReceived")
        val adapter =DeliveryAdapter(ArrayList(customername),ArrayList(moneystatus))
        binding.DeliveryRecyclerView.layoutManager =  LinearLayoutManager(this)
        binding.DeliveryRecyclerView.adapter = adapter

    }
}