package com.example.adminpanel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminpanel.Adapter.PendingOrderAdapter
import com.example.adminpanel.databinding.ActivityPendingOrderBinding

class PendingOrderActivity : AppCompatActivity() {
    private val binding:ActivityPendingOrderBinding by lazy {
        ActivityPendingOrderBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
binding.backButton.setOnClickListener { finish() }
        val customername = listOf("ali","hamza","hassan","murtaza")
        val quantity = listOf("4","2","3","1")
        val image = listOf(R.drawable.food_burger,R.drawable.food_res,R.drawable.food_burger,R.drawable.food_res)

        val adapter = PendingOrderAdapter(ArrayList(customername),ArrayList(quantity),ArrayList(image))
        binding.pendingOrderRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.pendingOrderRecyclerView.adapter = adapter

    }
}