package com.project.rickandmorty.presentation.listOfcharacter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.rickandmorty.data.apiservise.factory.APIFactory
import com.project.rickandmorty.data.domain.models.Characters
import com.project.rickandmorty.data.domain.repository.RickMortyRepository
import com.project.rickandmorty.data.domain.repository.result.UIResponseResult
import kotlinx.coroutines.launch

class ListOfCharactorsViewModel : ViewModel() {

    val repository = RickMortyRepository(APIFactory.rickAndMortyiAPI)

    val listObjData = MutableLiveData<List<Characters>?>()
    fun getCharacters(){
        viewModelScope.launch{
            val result = repository.getListCharacters()
            when(result){
                is UIResponseResult.Success -> listObjData.value = result.value
                is UIResponseResult.Error -> listObjData.value = null
            }
        }
    }
}