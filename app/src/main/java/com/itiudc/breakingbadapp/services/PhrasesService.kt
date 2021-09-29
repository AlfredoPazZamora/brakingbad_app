package com.itiudc.breakingbadapp.services

import com.itiudc.breakingbadapp.api.api
import com.itiudc.breakingbadapp.models.Phrases
import retrofit2.http.GET

interface PhrasesService {

    @GET("quote/random")
    suspend fun getRandomPhrase(): MutableList<Phrases>
}

var phrasesService: PhrasesService = api.create<PhrasesService>(PhrasesService::class.java)