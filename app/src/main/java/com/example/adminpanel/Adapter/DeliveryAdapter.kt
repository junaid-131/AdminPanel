package com.example.adminpanel.Adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminpanel.databinding.DeliveryItemBinding

class DeliveryAdapter(private val customerName:ArrayList<String>,private val moneyStatus:ArrayList<String>):RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder>() {
  inner  class DeliveryViewHolder(private val binding: DeliveryItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                CustomerName.text=customerName[position]
                MoneyStatus.text = moneyStatus[position]

                val colormap = mapOf("received" to Color.GREEN , "notReceived" to Color.RED , "pending" to Color.GRAY)
                MoneyStatus.setTextColor(colormap[moneyStatus[position]]?:Color.BLACK)
                colorstatus.backgroundTintList= ColorStateList.valueOf(colormap[moneyStatus[position]]?:Color.BLACK)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
        val binding = DeliveryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DeliveryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return customerName.size
    }

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        holder.bind(position)
    }
}