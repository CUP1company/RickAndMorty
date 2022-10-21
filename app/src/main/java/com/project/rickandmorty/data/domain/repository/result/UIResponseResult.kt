package com.project.rickandmorty.data.domain.repository.result

sealed class UIResponseResult<out T>{
    data class Success<out T>(val value: T) : UIResponseResult<T>()
    data class Error(val message: String): UIResponseResult<Nothing>()
}