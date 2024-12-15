package com.example.adminpanel.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminpanel.databinding.ItemItemBinding


class AllItemAdapter(private val MenuItemName: ArrayList<String>, private val MenuItemPrice: ArrayList<String>, private val MenuItemImage: ArrayList<Int>) : RecyclerView.Adapter<AllItemAdapter.AllitemViewHolder>() {
    private val itemQuantity = IntArray(MenuItemName.size) { 1 }

    inner class AllitemViewHolder(private val binding: ItemItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                MenuFoodName.text = MenuItemName[position]
                MenuPrice.text = MenuItemPrice[position]
                menuimage.setImageResource(MenuItemImage[position])

                MenuNegative.setOnClickListener {
                    decreaseQuantity(position)
                }
                MenuPlus.setOnClickListener {
                    IncreaseQuantity(position)
                }
                menuDelete.setOnClickListener {
                    DeleteQuantity(position)
                }
            }
        }
        private fun decreaseQuantity(position: Int) {
            if (itemQuantity[position] > 1) {
                itemQuantity[position]--
                binding.MENUItemNumber.text = itemQuantity[position].toString()
            }
        }
        private fun IncreaseQuantity(position: Int){
            if (itemQuantity[position]<10){
                itemQuantity[position]++
                binding.MENUItemNumber.text = itemQuantity[position].toString()
            }
        }
        private fun DeleteQuantity(position: Int){
            MenuItemName.removeAt(position)
            MenuItemPrice.removeAt(position)
            MenuItemImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,MenuItemName.size)
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllitemViewHolder {
            val binding =
                ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return AllitemViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return MenuItemName.size
        }

        override fun onBindViewHolder(holder: AllitemViewHolder, position: Int) {
            holder.bind(position)
        }
    }


