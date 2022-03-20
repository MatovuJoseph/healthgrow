package com.healthyentrepreneurs.healthgrow.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.healthyentrepreneurs.healthgrow.R
import com.healthyentrepreneurs.healthgrow.data.DummyData
import com.healthyentrepreneurs.healthgrow.data.adapters.LanguageAdapter
import com.healthyentrepreneurs.healthgrow.data.models.Language
import com.healthyentrepreneurs.healthgrow.databinding.ActivityLanguagePickerBinding

class LanguagePickerActivity : AppCompatActivity(), LanguageAdapter.LanguageCheckedListener {
    private val countryId by lazy {
        intent.getStringExtra("countryId")
    }
    lateinit var binding: ActivityLanguagePickerBinding

    private var selectedLanguage : Language? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguagePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Language"

        binding.nextBtn.isEnabled = false

        /*set up language picker recycler view*/
        binding.languagePickerRv.adapter =
            LanguageAdapter(this, DummyData.getCountryLanguages(countryId.toString()),this)

        binding.nextBtn.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    override fun onLanguageChecked(language: Language) {
        binding.nextBtn.isEnabled = true
        selectedLanguage = language

        setAppLanguage(selectedLanguage!!)

    }

    private fun setAppLanguage(language: Language) {

    }
}