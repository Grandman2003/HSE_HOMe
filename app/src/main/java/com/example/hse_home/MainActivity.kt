package com.example.hse_home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.adapters.MainElementsAdapter
import com.example.hse_home.databinding.ActivityMainBinding
import com.example.hse_home.models.Item
import com.example.hse_home.models.Profile
import com.example.hse_home.models.Skill

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var recyclerView:RecyclerView
    var items:ArrayList<Item> = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        recyclerView=binding.mainElementsRecycle
        fillList()
        with(recyclerView){
            layoutManager=LinearLayoutManager(context)
            adapter=MainElementsAdapter(items)
        }
        setContentView(binding.root)
    }

    private fun fillList() {
        items.add(0,Item.ProfileItem(Profile(resources.getString(R.string.first_name),resources.getString(R.string.last_name),resources.getString(R.string.info))))
        items.add(1,Item.ProjectInfo(resources.getString(R.string.project_info)))
        items.add(2,Item.Header(""))
        val skills:ArrayList<Skill> = ArrayList<Skill>()
        skills.add(Skill(resources.getString(R.string.and_dev),resources.getString(R.string.one_year)))
        skills.add(Skill(resources.getString(R.string.ser_dev),resources.getString(R.string.one_year)))
        skills.add(Skill(resources.getString(R.string.three_d_mod),resources.getString(R.string.two_years)))
        skills.add(Skill(resources.getString(R.string.vr_dev),resources.getString(R.string.polt_year)))
        items.add(3,Item.Skills(skills))
    }


}