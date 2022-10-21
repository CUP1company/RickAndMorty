package com.project.rickandmorty.data.domain.repository

import com.project.rickandmorty.data.apiservise.RickMortyAPICalls
import com.project.rickandmorty.data.domain.models.Characters
import com.project.rickandmorty.data.domain.repository.result.ResponseResult
import com.project.rickandmorty.data.domain.repository.result.UIResponseResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class RickMortyRepository(private val api: RickMortyAPICalls, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {

    suspend fun getListCharacters(): UIResponseResult<List<Characters>> {
        val result = BaseRepository.safeAPICall(dispatcher){
            api.getCharacter().await()
        }
        return when(result){
            is ResponseResult.Success -> {
                UIResponseResult.Success(result.value.results)
            }
            is ResponseResult.Error -> {
                UIResponseResult.Error("error")
            }
        }
    }
}