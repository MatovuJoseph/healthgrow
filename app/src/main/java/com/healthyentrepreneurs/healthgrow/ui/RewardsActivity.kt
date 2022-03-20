package com.healthyentrepreneurs.healthgrow.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.healthyentrepreneurs.healthgrow.data.DummyData.rewards
import com.healthyentrepreneurs.healthgrow.data.adapters.RewardAdapter
import com.healthyentrepreneurs.healthgrow.databinding.ActivityRewardsBinding

class RewardsActivity : AppCompatActivity() {
    lateinit var binding: ActivityRewardsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "My Rewards"

        /*setup rewards*/
        binding.rewardsRv.adapter = RewardAdapter(this,rewards)
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