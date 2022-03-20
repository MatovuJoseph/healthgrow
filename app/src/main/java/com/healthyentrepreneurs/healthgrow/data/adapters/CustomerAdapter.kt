package com.healthyentrepreneurs.healthgrow.data.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.healthyentrepreneurs.healthgrow.data.models.Customer
import com.healthyentrepreneurs.healthgrow.data.models.Language
import com.healthyentrepreneurs.healthgrow.databinding.SingleCustomerLayoutBinding
import com.healthyentrepreneurs.healthgrow.databinding.SingleLanguageLayoutBinding

class CustomerAdapter(val context: Context, val list: MutableList<Customer>) :
    RecyclerView.Adapter<CustomerAdapter.CustomerHolder>() {

    inner class CustomerHolder(val binding: SingleCustomerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setItemData(customer: Customer) {
            if (adapterPosition == 0){
                binding.status.text = "Not Submitted"
                binding.status.setTextColor(Color.parseColor("#FFdf5e28"))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerHolder {
        return CustomerHolder(
            SingleCustomerLayoutBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CustomerHolder, position: Int) {
        holder.setItemData(list[position])
    }

    override fun getItemCount(): Int = list.size
}