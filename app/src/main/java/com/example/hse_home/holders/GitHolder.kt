package com.example.hse_home.holders

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.databinding.ItemGithubBinding
import com.example.hse_home.models.Item


class GitHolder(var binding: ItemGithubBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: Item.ProfileItem){
        binding.profileName.text="${item.profile.firstname} ${item.profile.lastname}"
        binding.profileClass.text=item.profile.info
        binding.profileGithubButton.setOnClickListener {
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Grandman2003"))
                startActivity(binding.root.context,browserIntent,null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(binding.root.context, "No application can handle this request."
                            + " Please install a webbrowser", Toast.LENGTH_LONG
                ).show()
                e.printStackTrace()
            }
        }
    }
}