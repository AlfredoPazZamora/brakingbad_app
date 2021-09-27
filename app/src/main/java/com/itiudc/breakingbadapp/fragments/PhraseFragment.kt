package com.itiudc.breakingbadapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.itiudc.breakingbadapp.adapters.PhraseAdapter
import com.itiudc.breakingbadapp.databinding.FragmentPhraseBinding
import com.itiudc.breakingbadapp.models.Phrases
import com.itiudc.breakingbadapp.viewModels.PhrasesViewModel


class PhraseFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPhraseBinding.inflate(inflater, container, false)
        var phrasesViewModel = ViewModelProvider(this).get(PhrasesViewModel::class.java)

        phrasesViewModel.phrases.observe(
            viewLifecycleOwner,
            Observer<MutableList<Phrases>> { phrases ->
                val adapter = PhraseAdapter(phrases)

                binding.recyclerPhrasesItem.layoutManager = LinearLayoutManager(requireActivity())
                binding.recyclerPhrasesItem.adapter = adapter
            })

        return binding.root
    }
}