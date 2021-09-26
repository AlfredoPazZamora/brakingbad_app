package com.itiudc.breakingbadapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itiudc.breakingbadapp.models.Phrases
import com.itiudc.breakingbadapp.services.phrasesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhrasesViewModel : ViewModel() {
    private var _phrases = MutableLiveData<MutableList<Phrases>>()
    val phrases: LiveData<MutableList<Phrases>>
        get() = _phrases

    init {
        viewModelScope.launch {
            _phrases.value = fetch()
        }
    }

    private suspend fun fetch(): MutableList<Phrases>{
        return withContext(Dispatchers.IO){
            val phrases: MutableList<Phrases> = phrasesService.getPhrases()

            phrases

        }
    }
}