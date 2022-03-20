package com.healthyentrepreneurs.healthgrow.ui.customer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.healthyentrepreneurs.healthgrow.data.adapters.CustomerAdapter
import com.healthyentrepreneurs.healthgrow.data.models.Customer
import com.healthyentrepreneurs.healthgrow.databinding.ActivityCustomerRegistryBinding

class CustomerRegistryActivity : AppCompatActivity() {
    lateinit var binding: ActivityCustomerRegistryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerRegistryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Customer Registry"

        /*link to adding new customer*/
        binding.addBtn.setOnClickListener {
            startActivity(Intent(this,NewCustomerActivity::class.java))
        }

        binding.customerRv.adapter = CustomerAdapter(this, mutableListOf(
            Customer(),Customer(),Customer(),Customer(),Customer(),Customer()
        ))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                onBackPressed()
            }
        }
        return true
    }
}