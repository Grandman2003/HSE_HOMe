package com.example.hse_home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.adapters.MainElementsAdapter
import com.example.hse_home.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var recyclerView:RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        recyclerView=binding.mainElementsRecycle
        with(recyclerView){
            layoutManager=LinearLayoutManager(context)
            adapter=MainElementsAdapter()
        }
        setContentView(binding.root)
    }
}