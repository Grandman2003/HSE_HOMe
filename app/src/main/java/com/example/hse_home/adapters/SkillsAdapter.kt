package com.example.hse_home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.databinding.ItemMySkillBinding
import com.example.hse_home.holders.NavikHolder
import com.example.hse_home.models.Skill

class SkillsAdapter(var skills:List<Skill>): RecyclerView.Adapter<NavikHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavikHolder=
        NavikHolder(ItemMySkillBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    override fun onBindViewHolder(holder: NavikHolder, position: Int) {
        holder.onBind(skills[position])
    }
    override fun getItemCount(): Int =
        skills.size
}