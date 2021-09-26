package com.itiudc.breakingbadapp.activities.mainscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.itiudc.breakingbadapp.R
import com.itiudc.breakingbadapp.activities.detailscreen.DetailActivity
import com.itiudc.breakingbadapp.adapters.TabLayoutAdapter
import com.itiudc.breakingbadapp.databinding.ActivityMainBinding
import com.itiudc.breakingbadapp.fragments.CharactersListFragment
import com.itiudc.breakingbadapp.models.Character

class MainActivity : AppCompatActivity(), CharactersListFragment.CharacterSelectListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val tabLayoutAdapter = TabLayoutAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager2)
        viewPager.adapter = tabLayoutAdapter

        val tabs: TabLayout = findViewById(R.id.tabLayout)

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getStringArray(R.array.tabLayoutStrings)[position]
        }.attach()

    }

    override fun onCharacterSelected(character: Character) {
        Log.i("Edg", "Character loaded on MainActivity: ${character.name}")

        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }
}