package com.itiudc.breakingbadapp.activities.detailscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.itiudc.breakingbadapp.R
import com.itiudc.breakingbadapp.databinding.ActivityDetailBinding
import com.itiudc.breakingbadapp.models.Character

class DetailActivity : AppCompatActivity() {

    companion object {
        const val CHARACTER_KEY = "character_item"
        const val CHARACTER_IMAGE = "character_image"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        val bundle: Bundle? = intent.extras

        if(bundle != null) {
            val character = bundle.getParcelable<Character>(CHARACTER_KEY)

            binding.nameDetail.text = character?.name.toString()
            binding.nicknameDetail.text = character?.nickname.toString()

            Glide
                .with(binding.root)
                .load(character?.img)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imgProfile)

            binding.textStatusDetail.text = character?.status.toString()
            binding.textDateDetail.text = character?.birthday.toString()

            when(character?.status){
                "Deceased" -> Glide
                    .with(binding.root)
                    .load(R.drawable.icon_deceased)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.iconStatusDetail)
                "Alive" -> Glide
                    .with(binding.root)
                    .load(R.drawable.icon_alive)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.iconStatusDetail)
                "Presumed dead" -> Glide
                    .with(binding.root)
                    .load(R.drawable.icon_unknow)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.iconStatusDetail)
            }


            val occupationText = character?.occupation?.joinToString(", ").toString()

            binding.textOccupationDetail.text = occupationText

            binding.textActorDetail.text = character?.portrayed.toString()


        }
    }
}