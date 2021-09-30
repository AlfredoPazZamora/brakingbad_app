package com.itiudc.breakingbadapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itiudc.breakingbadapp.R
import com.itiudc.breakingbadapp.databinding.CharacterListItemBinding
import com.itiudc.breakingbadapp.models.Character

class CharacterListAdapter(private val characterList: List<Character>) : RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    lateinit var onClickItem: (Character) -> Unit

    inner class ViewHolder(private val binding: CharacterListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character){
            binding.nameCharacter.text = character.name
            binding.nicknameCharacter.text = character.nickname
            Glide
                .with(binding.root)
                .load(character.img)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imgCharacter)

            when(character.status){
                "Deceased" -> Glide
                                .with(binding.root)
                                .load(R.drawable.icon_deceased)
                                .centerCrop()
                                .placeholder(R.drawable.ic_launcher_foreground)
                                .into(binding.iconStatusCharacter)
                "Alive" -> Glide
                            .with(binding.root)
                            .load(R.drawable.icon_alive)
                            .centerCrop()
                            .placeholder(R.drawable.ic_launcher_foreground)
                            .into(binding.iconStatusCharacter)
                "Presumed dead" -> Glide
                                    .with(binding.root)
                                    .load(R.drawable.icon_unknow)
                                    .centerCrop()
                                    .placeholder(R.drawable.ic_launcher_foreground)
                                    .into(binding.iconStatusCharacter)

            }

            binding.root.setOnClickListener(){
                if(::onClickItem.isInitialized)
                    onClickItem(character)
                else
                    Log.i("edg", "onMovieClick is not initialized")
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterListItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.count()
    }
}