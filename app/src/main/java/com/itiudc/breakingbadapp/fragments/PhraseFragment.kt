package com.itiudc.breakingbadapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import com.itiudc.breakingbadapp.databinding.FragmentPhraseBinding
import com.itiudc.breakingbadapp.models.Phrases
import com.itiudc.breakingbadapp.viewModels.PhrasesViewModel


class PhraseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPhraseBinding.inflate(inflater, container, false)
        val phrasesViewModel = ViewModelProvider(this).get(PhrasesViewModel::class.java)

        phrasesViewModel.phrases.observe(viewLifecycleOwner,Observer<MutableList<Phrases>> {
            phrase ->
                binding.authorText.text = phrase[0].author
                binding.phraseText.text = phrase[0].quote
        })

        binding.root.setOnClickListener{
            phrasesViewModel.getPhrase()
        }

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        val phrasesViewModel = ViewModelProvider(this).get(PhrasesViewModel::class.java)
        phrasesViewModel.getPhrase()
    }
}