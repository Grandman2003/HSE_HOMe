package com.example.hse_home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.databinding.ItemGithubBinding
import com.example.hse_home.databinding.ItemHeaderBinding
import com.example.hse_home.databinding.ItemProjectIdeaBinding
import com.example.hse_home.databinding.ItemSkillsBinding
import com.example.hse_home.holders.GitHolder
import com.example.hse_home.holders.HeaderHolder
import com.example.hse_home.holders.ProjectInfoHolder
import com.example.hse_home.holders.SkillsHolder
import com.example.hse_home.models.Item

class MainElementsAdapter(var items: List<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder=
        when(viewType){
            VIEW_TYPE_GIT->
                GitHolder(ItemGithubBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            VIEW_TYPE_INFO->
                ProjectInfoHolder(ItemProjectIdeaBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            VIEW_TYPE_HEADER->
                HeaderHolder(ItemHeaderBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            VIEW_TYPE_SKILLS->
                SkillsHolder(ItemSkillsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            else ->
                throw IllegalArgumentException("")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(val Item=items[position]){
            is Item.ProfileItem->
                (holder as? GitHolder)?.onBind(Item)
            is Item.ProjectInfo->
                (holder as? ProjectInfoHolder)?.onBind(Item)
            is Item.Header->
                (holder as? HeaderHolder)?.onBind(Item)
            is Item.Skills->
                (holder as? SkillsHolder)?.onBind(Item)
        }
    }

    override fun getItemCount(): Int=items.size

    override fun getItemViewType(position: Int): Int=
        when(items[position]){
            is Item.ProfileItem->
                VIEW_TYPE_GIT
            is Item.ProjectInfo->
                VIEW_TYPE_INFO
            is Item.Header->
                VIEW_TYPE_HEADER
            is Item.Skills->
                VIEW_TYPE_SKILLS
        }


    companion object {
        const val VIEW_TYPE_GIT = 0
        const val VIEW_TYPE_INFO = 1
        const val VIEW_TYPE_HEADER = 2
        const val VIEW_TYPE_SKILLS = 3
    }
}