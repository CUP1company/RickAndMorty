package com.project.rickandmorty.data.domain.models

data class MainResponse(
    val info: Info,
    val results: List<Characters>
)
