package com.healthyentrepreneurs.healthgrow.data.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.healthyentrepreneurs.healthgrow.data.models.Country
import com.healthyentrepreneurs.healthgrow.data.models.Language
import com.healthyentrepreneurs.healthgrow.databinding.SingleLanguageLayoutBinding

class LanguageAdapter(val context: Context, val list: MutableList<Language>, val listener: LanguageCheckedListener) :
    RecyclerView.Adapter<LanguageAdapter.LanguageHolder>() {

    private var activePosition: Int? = null

    inner class LanguageHolder(val binding: SingleLanguageLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setItemData(language: Language) {
            binding.radioBtn.text = language.name
            binding.radioBtn.isChecked = adapterPosition == activePosition

            binding.radioBtn.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    listener.onLanguageChecked(language)
                    val oldSelection = activePosition
                    activePosition = adapterPosition
                    notifyItemChanged(adapterPosition)
                    oldSelection?.let { notifyItemChanged(it) }
                    notifyDataSetChanged()
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageHolder {
        return LanguageHolder(
            SingleLanguageLayoutBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LanguageHolder, position: Int) {
        holder.setItemData(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface LanguageCheckedListener{
        fun onLanguageChecked(language: Language)
    }
}