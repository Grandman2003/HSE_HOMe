package com.example.hse_home.holders

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.MainActivity
import com.example.hse_home.R
import com.example.hse_home.databinding.ItemHeaderBinding
import com.example.hse_home.dialogs.FilterDialog
import com.example.hse_home.models.Item

class HeaderHolder(var binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: Item.Header,activity: Activity){
        Log.v("PREF_START_DIA",activity.getPreferences(Context.MODE_PRIVATE).getStringSet(FilterDialog.FILTER_KEY,null)?.size.toString())
        if(activity.getPreferences(Context.MODE_PRIVATE).getStringSet(FilterDialog.FILTER_KEY,null)?.size!=null){
        when(activity.getPreferences(Context.MODE_PRIVATE).getStringSet(FilterDialog.FILTER_KEY,null)?.size!=0
                && activity.getPreferences(Context.MODE_PRIVATE).getStringSet(FilterDialog.FILTER_KEY,null)?.size!! < 3) {
            true ->{
                binding.filterButton.setImageResource(R.drawable.activated_filters)
                Log.v("PREF_START_YES","HAHAH")
            }
            else ->binding.filterButton.setImageResource(R.drawable.filter_icon)
        }}else{
            Log.v("PREF_START_NONE","HAHAH")
            binding.filterButton.setImageResource(R.drawable.filter_icon)
        }
        binding.filterButton.setOnClickListener {
            val dialog=FilterDialog(activity)
            dialog.show((activity as MainActivity).supportFragmentManager,"FilterDialog")
        }
    }
}