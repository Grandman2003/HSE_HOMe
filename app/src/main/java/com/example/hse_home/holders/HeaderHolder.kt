package com.example.hse_home.holders

import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.databinding.ItemHeaderBinding
import com.example.hse_home.models.Item

class HeaderHolder(var binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: Item.Header){
        binding.filterButton.setOnClickListener {

        }
    }
}