package com.example.adminpanel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminpanel.Adapter.AllItemAdapter
import com.example.adminpanel.databinding.ActivityAllItemBinding
import java.util.ArrayList

class AllItemActivity : AppCompatActivity() {
    private val binding:ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
        }
        val foodname = listOf("burger","pizza")
        val foodprice = listOf("13$","5$")
        val foodimage = listOf(R.drawable.food_burger,R.drawable.food_res)

        val adapter = AllItemAdapter(ArrayList( foodname),ArrayList(foodprice),ArrayList(foodimage))

        binding.menuRecylerview.layoutManager = LinearLayoutManager(this)
        binding.menuRecylerview.adapter=adapter

    }
}