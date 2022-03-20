package com.healthyentrepreneurs.healthgrow.data.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.healthyentrepreneurs.healthgrow.data.models.Reward
import com.healthyentrepreneurs.healthgrow.databinding.SingleRewardLayoutBinding

class RewardAdapter(val context: Context, val list: MutableList<Reward>) :
    RecyclerView.Adapter<RewardAdapter.RewardHolder>() {

    inner class RewardHolder(val binding: SingleRewardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setItemData(reward: Reward) {
            binding.progress.text = "${reward.progress}/${reward.total_points}"
            binding.title.text = reward.title
            binding.progressBar.progress = reward.progress!!

            Glide.with(context).load(reward.icon).into(binding.icon)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardHolder {
        return RewardHolder(
            SingleRewardLayoutBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RewardHolder, position: Int) {
        holder.setItemData(list[position])
    }

    override fun getItemCount(): Int = list.size
}