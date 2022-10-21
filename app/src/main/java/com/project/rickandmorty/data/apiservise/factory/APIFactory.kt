package com.project.rickandmorty.data.apiservise.factory

import com.project.rickandmorty.data.apiservise.RickMortyAPICalls
import retrofit2.create

object APIFactory {
    val rickAndMortyiAPI: RickMortyAPICalls = RetrofitFactory.retrofit(baseUrl = "https://rickandmortyapi.com/api/")
        .create()
}