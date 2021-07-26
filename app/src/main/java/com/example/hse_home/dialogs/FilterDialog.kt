package com.example.hse_home.dialogs

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.graphics.PorterDuff
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.hse_home.MainActivity
import com.example.hse_home.R
import com.example.hse_home.databinding.DialogFiltersBinding
import java.util.prefs.Preferences

class FilterDialog(activity: Activity): DialogFragment() {

    private var _binding:DialogFiltersBinding?=null
    private val binding get()=_binding!!

    private var filters:ArrayList<String> = ArrayList<String>()
    var isUsed: Boolean=false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= DialogFiltersBinding.inflate(layoutInflater,container,false)
        val view: View=binding.root

        var preferences: SharedPreferences? =activity?.getPreferences(Context.MODE_PRIVATE)
       /* if(preferences!=null){
            if(preferences.getStringSet(FILTER_KEY,null)?.contains(context?.getString(R.string.one_year)) == true){
                binding.oneCheck.isChecked
            }
            if(preferences.getStringSet(FILTER_KEY,null)?.contains(context?.getString(R.string.two_years)) == true){
                binding.twoCheck.isChecked
            }
            if(preferences.getStringSet(FILTER_KEY,null)?.contains(context?.getString(R.string.polt_year)) == true){
                binding.poltoraHceck.isChecked
            }
            if(binding.oneCheck.isChecked && binding.twoCheck.isChecked && binding.poltoraHceck.isChecked ){
                binding.allCheck.isChecked
            }
        } */
        binding.oneCheck.setOnClickListener(View.OnClickListener {
            when(binding.oneCheck.isChecked){
                true -> context?.getString(R.string.one_year)?.let { it1 -> filters.add(it1)
                }
                else -> {
                    binding.allCheck.isChecked=false
                    filters.remove(context?.getString(R.string.one_year))
                }
            }
            isUsed=true
            Log.i("CHOOSED_FILTERS",filters.size.toString())
            Log.i("CONTEXT_NULL",context.toString())
        })

        binding.twoCheck.setOnClickListener(View.OnClickListener {
            when(binding.twoCheck.isChecked){
                true -> context?.getString(R.string.two_years)?.let { it1 -> filters.add(it1) }
                else -> {
                    binding.allCheck.isChecked=false
                    filters.remove(context?.getString(R.string.two_years))
                }
            }
            isUsed=true
            Log.i("CHOOSED_FILTERS",filters.size.toString())
            Log.i("CONTEXT_NULL",context.toString())
        })
        binding.poltoraHceck.setOnClickListener(View.OnClickListener {
            when(binding.poltoraHceck.isChecked){
                true -> context?.getString(R.string.polt_year)?.let { it1 -> filters.add(it1) }

                else -> {
                    binding.allCheck.isChecked=false
                    filters.remove(context?.getString(R.string.polt_year))
                }
            }
            isUsed=true
            Log.i("CHOOSED_FILTERS",filters.size.toString())
            Log.i("CONTEXT_NULL",context.toString())
        })
        binding.allCheck.setOnClickListener(View.OnClickListener {
            when(binding.allCheck.isChecked){
                true -> {
                    binding.oneCheck.isChecked=true
                    binding.twoCheck.isChecked=true
                    binding.poltoraHceck.isChecked=true
                    context?.getString(R.string.one_year)?.let { it1 -> filters.add(it1) }
                    context?.getString(R.string.two_years)?.let { it1 -> filters.add(it1) }
                    context?.getString(R.string.polt_year)?.let { it1 -> filters.add(it1) }
                }
                else ->{
                    binding.oneCheck.isChecked=false
                    binding.twoCheck.isChecked=false
                    binding.poltoraHceck.isChecked=false
                    filters.remove(context?.getString(R.string.one_year))
                    filters.remove(context?.getString(R.string.two_years))
                    filters.remove(context?.getString(R.string.polt_year))
                }
            }
            isUsed=true
            Log.i("CHOOSED_FILTERS",filters.size.toString())
            Log.i("CONTEXT_NULL",context.toString())
        })

        binding.button.setOnClickListener {
            onFiltersActivate()
            this.dismiss()
        }

        return view
    }

    fun onFiltersActivate(){
        val preferences: SharedPreferences? =activity?.getPreferences(Context.MODE_PRIVATE)
        if(!isUsed){
            context?.getString(R.string.one_year)?.let { it1 -> filters.add(it1) }
            context?.getString(R.string.two_years)?.let { it1 -> filters.add(it1) }
            context?.getString(R.string.polt_year)?.let { it1 -> filters.add(it1) }
        }
        with(preferences?.edit()){
            this?.putStringSet(FILTER_KEY,filters.toHashSet())
            this?.apply()
            Log.i("CHOOSED_FILTERS",filters.size.toString())
            Log.i("FILTERS_SET",preferences?.getStringSet(FILTER_KEY,null)?.size.toString())
            (activity as? MainActivity)?.refillList()
        }
    }

    companion object{
        const val FILTER_KEY:String="FILTERS"
    }
}