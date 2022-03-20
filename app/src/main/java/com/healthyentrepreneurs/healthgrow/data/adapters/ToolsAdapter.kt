package com.healthyentrepreneurs.healthgrow.data.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.healthyentrepreneurs.healthgrow.data.models.Tool
import com.healthyentrepreneurs.healthgrow.databinding.SingleToolLayoutBinding
import com.healthyentrepreneurs.healthgrow.ui.customer.CustomerRegistryActivity
import com.healthyentrepreneurs.healthgrow.ui.products.ProductSalesActivity

class ToolsAdapter(val context: Context, val list: MutableList<Tool>): RecyclerView.Adapter<ToolsAdapter.ToolHolder>() {

    inner class ToolHolder(val binding: SingleToolLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun setItemData(tool: Tool) {
            tool.icon?.let { binding.toolIcon.setImageResource(it) }
            binding.toolTitle.text = tool.title

            binding.root.setOnClickListener {
                when(tool.id){
                    1->{
                        context.startActivity(Intent(context, CustomerRegistryActivity::class.java))
                    }
                    2->{
                        context.startActivity(Intent(context, ProductSalesActivity::class.java))
                    }
                    3->{}
                    4->{}
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolHolder {
        return ToolHolder(SingleToolLayoutBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ToolHolder, position: Int) {
        holder.setItemData(list[position])
    }

    override fun getItemCount(): Int = list.size
}