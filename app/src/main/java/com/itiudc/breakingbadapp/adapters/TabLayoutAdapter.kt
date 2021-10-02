package com.itiudc.breakingbadapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.itiudc.breakingbadapp.fragments.CharactersListFragment
import com.itiudc.breakingbadapp.fragments.PhraseFragment
import com.itiudc.breakingbadapp.fragments.SettingsFragment

class TabLayoutAdapter(fm: FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CharactersListFragment()
            2 -> SettingsFragment()
            1 -> PhraseFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}