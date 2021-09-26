package com.itiudc.breakingbadapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.itiudc.breakingbadapp.R
import com.itiudc.breakingbadapp.adapters.CharacterListAdapter
import com.itiudc.breakingbadapp.databinding.ActivityMainBinding
import com.itiudc.breakingbadapp.databinding.FragmentCharactersListBinding
import com.itiudc.breakingbadapp.models.Character
import com.itiudc.breakingbadapp.viewModels.CharacterViewModel

class CharactersListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        val binding = FragmentCharactersListBinding.inflate(inflater, container, false)

        characterViewModel.characters.observe(viewLifecycleOwner, Observer<MutableList<Character>> {
            characters ->

            val adapter = CharacterListAdapter(characters)

            adapter.onClickItem = {
                Log.i("edg", "Character ${it.name}")
            }

            binding.recyclerCharacterList.layoutManager = LinearLayoutManager(requireActivity())
            binding.recyclerCharacterList.adapter = adapter

        })

        return binding.root
    }


}