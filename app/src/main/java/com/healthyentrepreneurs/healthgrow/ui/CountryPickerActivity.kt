package com.healthyentrepreneurs.healthgrow.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.healthyentrepreneurs.healthgrow.R
import com.healthyentrepreneurs.healthgrow.data.DummyData
import com.healthyentrepreneurs.healthgrow.data.adapters.CountryAdapter
import com.healthyentrepreneurs.healthgrow.data.adapters.CountryCheckedListener
import com.healthyentrepreneurs.healthgrow.data.models.Country
import com.healthyentrepreneurs.healthgrow.databinding.ActivityCountryPickerBinding

class CountryPickerActivity : AppCompatActivity(), CountryCheckedListener {
    lateinit var binding: ActivityCountryPickerBinding

    private var selectedCountry : Country? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryPickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Welcome to HealthGrow"

        binding.nextBtn.isEnabled = false

        /*set up country picker*/
        binding.countryPickerRv.adapter = CountryAdapter(this, DummyData.countries,this)
        binding.countryPickerRv.setHasFixedSize(true)
        binding.countryPickerRv.recycledViewPool.setMaxRecycledViews(0,0)

        binding.nextBtn.setOnClickListener {
            startActivity(Intent(this,LanguagePickerActivity::class.java)
                .putExtra("countryId",selectedCountry?.id.toString()))
        }
    }

    override fun onCountryChecked(country: Country) {
        binding.nextBtn.isEnabled = true
        selectedCountry = country
    }

    override fun clearCheckedCountry() {
        binding.nextBtn.isEnabled = false
    }
}