package com.itiudc.breakingbadapp.activities.detailscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.itiudc.breakingbadapp.R
import com.itiudc.breakingbadapp.databinding.ActivityDetailBinding
import com.itiudc.breakingbadapp.models.Character

class DetailActivity : AppCompatActivity() {

    companion object {
        const val CHARACTER_KEY = "character_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        val bundle: Bundle? = intent.extras

        if(bundle != null) {
            val character = bundle.getParcelable<Character>(CHARACTER_KEY)
            binding.title.text = character?.name
        }
    }
}