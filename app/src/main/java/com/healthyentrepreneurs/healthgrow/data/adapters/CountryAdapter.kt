package com.healthyentrepreneurs.healthgrow.data.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.healthyentrepreneurs.healthgrow.data.models.Country
import com.healthyentrepreneurs.healthgrow.databinding.SingleCountryLayoutBinding

class CountryAdapter(val context: Context, val list: MutableList<Country>, val listener: CountryCheckedListener) :
    RecyclerView.Adapter<CountryAdapter.CountryHolder>() {

    private var checkedItemPosition: Int? = null

    inner class CountryHolder(val binding: SingleCountryLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setItemData(country: Country) {
            binding.countryName.text = country.country_name
            Glide.with(context).load(country.country_flag).into(binding.countryFlag)

            binding.checkbox.isChecked = adapterPosition == checkedItemPosition

            binding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
                when(isChecked){
                    true-> {
                        listener.onCountryChecked(country)
                        val oldSelection = checkedItemPosition
                        checkedItemPosition = adapterPosition
                        notifyItemChanged(adapterPosition)
                        oldSelection?.let { notifyItemChanged(it) }
                        notifyDataSetChanged()
                    }

                    else-> {
                        listener.clearCheckedCountry()
                        checkedItemPosition = null
                        notifyItemChanged(adapterPosition)
                        notifyDataSetChanged()
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        return CountryHolder(
            SingleCountryLayoutBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.setItemData(list[position])
    }

    override fun getItemCount(): Int = list.size
}

interface CountryCheckedListener{
    fun onCountryChecked(country: Country)
    fun clearCheckedCountry()
}