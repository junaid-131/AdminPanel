package com.example.adminpanel.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.adminpanel.PendingOrderActivity
import com.example.adminpanel.databinding.ActivityPendingOrderBinding
import com.example.adminpanel.databinding.PendingorderitemBinding

class PendingOrderAdapter(private val pendingname:ArrayList<String>,private val pendingquntity:ArrayList<String>,private val pendingimage:ArrayList<Int>):RecyclerView.Adapter<PendingOrderAdapter.PendingViewHolder>() {
    private var isAccepted = false
   inner class PendingViewHolder(private val binding: PendingorderitemBinding):RecyclerView.ViewHolder(binding.root) {
       fun bind(position: Int) {
            binding.apply {
                pendingcustomername.text = pendingname[position]
                pendingquantityy.text = pendingquntity[position]
                pendingorderImage.setImageResource(pendingimage[position])

                btnAccept.apply {
                    if (!isAccepted){
                        text = "Accept"
                    }
                    else{
                        text ="Dispatch"
                    }
                    setOnClickListener{
                        if (!isAccepted){
                            text = "Dispatch"
                            isAccepted = true

                        }
                        else{
                            pendingname.removeAt(adapterPosition)
                            notifyItemChanged(adapterPosition)
                            notifyItemRemoved(adapterPosition)

                        }

                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendingViewHolder {
       val bindig = PendingorderitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PendingViewHolder(bindig)
    }

    override fun getItemCount(): Int {
        return pendingname.size
    }

    override fun onBindViewHolder(holder: PendingViewHolder, position: Int) {
       holder.bind(position)
    }
}