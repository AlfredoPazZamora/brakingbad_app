package com.itiudc.breakingbadapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.itiudc.breakingbadapp.R
import com.itiudc.breakingbadapp.adapters.CharacterListAdapter
import com.itiudc.breakingbadapp.databinding.ActivityMainBinding
import com.itiudc.breakingbadapp.databinding.FragmentCharactersListBinding
import com.itiudc.breakingbadapp.models.Character

class CharactersListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCharactersListBinding.inflate(inflater, container, false)

        val characters = mutableListOf<Character>(
            Character(1,"XD", "UN DIA", "https://imagenes.heraldo.es/files/image_990_v1/uploads/imagenes/2013/10/17/_walterwhite_0ae55f6d.jpg", "Alive", "CHARIBU"),
            Character(2,"XD2", "UN DIA 2", "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2019/07/gus-fring-breaking-bad-giancarlo-esposito.jpg?itok=jlPLiQFA", "Deceased", "CHARIBU2"),
            Character(3,"XD3", "UN DIA 3", "https://poptv.orange.es/wp-content/uploads/sites/3/2018/07/jonathan-banks-1024x698.jpg", "Presumed dead", "CHARIBU3")
        )
        val adapter = CharacterListAdapter(characters)


        binding.recyclerCharacterList.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerCharacterList.adapter = adapter


        return binding.root
    }


}