package com.itiudc.breakingbadapp.services

import com.itiudc.breakingbadapp.api.Response
import com.itiudc.breakingbadapp.api.api
import com.itiudc.breakingbadapp.models.Character
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {

    @GET("characters")
    suspend fun getCharacters(): MutableList<Character>
}

var characterService: CharacterService = api.create<CharacterService>(CharacterService::class.java)