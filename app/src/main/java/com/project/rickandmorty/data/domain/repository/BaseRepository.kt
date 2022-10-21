package com.project.rickandmorty.data.domain.repository

import com.project.rickandmorty.data.domain.repository.result.ResponseResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response

object BaseRepository {
    suspend fun <T> safeAPICall(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> Response<T>,
    ): ResponseResult<T> {

        return withContext(dispatcher){
            val response = apiCall.invoke()

            when(response.code()){
                200 -> ResponseResult.Success(response.body()!!)
                else -> ResponseResult.Error(response.code())
            }
        }
    }

}