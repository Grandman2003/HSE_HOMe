package com.example.hse_home

import android.content.Context
import android.content.SharedPreferences
import android.opengl.Visibility
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.adapters.MainElementsAdapter
import com.example.hse_home.databinding.ActivityMainBinding
import com.example.hse_home.dialogs.FilterDialog
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
        setSupportActionBar(binding.toolbarCross)
        with(getPreferences(MODE_PRIVATE).edit()){
            clear()
            apply()
        }

        TODO("FIX_FILTERS_RESTART")

        Log.v("PREF_START",getPreferences(Context.MODE_PRIVATE).getStringSet(FilterDialog.FILTER_KEY,null)?.size.toString())
        with(supportActionBar){
            this?.hide()
           this?.title=""
        }
        fillList()
        with(recyclerView){
            layoutManager=LinearLayoutManager(context)
            adapter=MainElementsAdapter(items,this@MainActivity)
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

    fun refillList(){
        val sorted_List: ArrayList<Skill> = ArrayList<Skill>()
        val preferences: SharedPreferences=getPreferences(Context.MODE_PRIVATE)
        with(preferences) {
            for(element:Skill in (items.get(3) as Item.Skills).skills){
                if(this.getStringSet(FilterDialog.FILTER_KEY,null)?.contains(element.level) == true){
                    sorted_List.add(element)
                }
            }
        }
        val new_items: ArrayList<Item> = items.clone() as ArrayList<Item>
        new_items.removeAt(3)
        new_items.add(3,Item.Skills(sorted_List))

        with(recyclerView){
            adapter=MainElementsAdapter(new_items,this@MainActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        with(getPreferences(MODE_PRIVATE).edit()) {
            clear()
            apply()
        }
    }

        override fun onRestart() {
            super.onRestart()
            with(getPreferences(MODE_PRIVATE).edit()){
                clear()
                apply()
            }
        }



    }

