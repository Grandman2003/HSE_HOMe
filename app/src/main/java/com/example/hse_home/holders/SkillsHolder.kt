package com.example.hse_home.holders

import android.app.Activity
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.adapters.SkillsAdapter
import com.example.hse_home.databinding.ItemSkillsBinding
import com.example.hse_home.models.Item

class SkillsHolder(var binding: ItemSkillsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: Item.Skills){
        with(binding.myskillsRecycle){
           layoutManager=LinearLayoutManager(context)
            adapter=SkillsAdapter(item.skills)
        }
    }

}