package com.healthyentrepreneurs.healthgrow.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.healthyentrepreneurs.healthgrow.R
import com.healthyentrepreneurs.healthgrow.data.DummyData.tools
import com.healthyentrepreneurs.healthgrow.data.adapters.ToolsAdapter
import com.healthyentrepreneurs.healthgrow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*set up tools*/
        binding.toolsRv.adapter = ToolsAdapter(this,tools)

        /*link to rewards activity*/
        binding.viewRewardsBtn.setOnClickListener {
            startActivity(Intent(this,RewardsActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
}