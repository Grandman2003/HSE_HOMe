package com.example.hse_home.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.databinding.ItemHeaderBinding
import com.example.hse_home.databinding.ItemMySkillBinding
import com.example.hse_home.models.Skill

class NavikHolder(var binding: ItemMySkillBinding) : RecyclerView.ViewHolder(binding.root)  {
    fun onBind(item:Skill){
        binding.skillName.text=item.name
        binding.duration.text=item.level
    }
}