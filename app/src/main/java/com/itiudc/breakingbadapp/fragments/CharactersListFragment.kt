package com.itiudc.breakingbadapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.itiudc.breakingbadapp.adapters.CharacterListAdapter
import com.itiudc.breakingbadapp.databinding.FragmentCharactersListBinding
import com.itiudc.breakingbadapp.models.Character
import com.itiudc.breakingbadapp.viewModels.CharacterViewModel
import java.lang.ClassCastException

class CharactersListFragment : Fragment() {

    public interface CharacterSelectListener{
        fun onCharacterSelected(character: Character)
    }

    private lateinit var characterSelectListener: CharacterSelectListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        characterSelectListener = try {
            context as CharacterSelectListener
        }catch (error: ClassCastException){
            throw ClassCastException("$context must implement CharacterSelectListener")
        }
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
                characterSelectListener.onCharacterSelected(it)
            }

            binding.recyclerCharacterList.layoutManager = LinearLayoutManager(requireActivity())
            binding.recyclerCharacterList.adapter = adapter

        })

        return binding.root
    }


}