package com.project.rickandmorty.data.apiservise

import com.project.rickandmorty.data.domain.models.MainResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface RickMortyAPICalls {
    @GET("character")
    fun getCharacter(): Deferred<Response<MainResponse>>
}