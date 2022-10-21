package com.project.rickandmorty.data.domain.repository.result

sealed class ResponseResult<out T> {
    data class Success<out T>(val value: T) : ResponseResult<T>()
    data class Error(val errorCode: Int): ResponseResult<Nothing>()
}