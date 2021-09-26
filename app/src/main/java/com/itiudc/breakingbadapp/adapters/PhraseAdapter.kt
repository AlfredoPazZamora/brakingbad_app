package com.itiudc.breakingbadapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itiudc.breakingbadapp.databinding.PhrasesItemBinding
import com.itiudc.breakingbadapp.models.Phrases

class PhraseAdapter(private val Phrase: List<Phrases>) : RecyclerView.Adapter<PhraseAdapter.ViewHolder>() {



    inner class ViewHolder(private val binding: PhrasesItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(phrases: Phrases){

            binding.phraseText.text = phrases.quote
            binding.authorText.text = phrases.author

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PhrasesItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(Phrase[position])
    }

    override fun getItemCount(): Int {
        return Phrase.count()
    }
}