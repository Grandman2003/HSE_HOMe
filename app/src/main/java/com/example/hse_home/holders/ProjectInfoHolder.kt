package com.example.hse_home.holders

import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.databinding.ItemProjectIdeaBinding
import com.example.hse_home.models.Item

class ProjectInfoHolder(var binding: ItemProjectIdeaBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: Item.ProjectInfo){
        binding.textView.text=item.info
    }
}