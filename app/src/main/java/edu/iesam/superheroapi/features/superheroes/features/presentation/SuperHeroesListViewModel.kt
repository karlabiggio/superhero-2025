package edu.iesam.superheroapi.features.superheroes.presentation

import androidx.annotation.RestrictTo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroapi.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroapi.features.superheroes.domain.ErrorApp
import edu.iesam.superheroapi.features.superheroes.domain.FetchSuperheroesUseCase
import edu.iesam.superheroapi.features.superheroes.domain.SuperHeroe
import edu.iesam.superheroapi.features.superheroes.domain.SuperheroRepository
import kotlinx.coroutines.launch

class SuperHeroesListViewModel(private val fetchSuperheroesUseCase: FetchSuperheroesUseCase) :
    ViewModel(){

        private val _uiState = MutableLiveData<UIState>()
        val uiState : LiveData<UIState> = _uiState


     fun loadSuperHeroes() {
        viewModelScope.launch {
            _uiState.value = UIState(isLoading = true)
            fetchSuperheroesUseCase().fold(
                {
                    onSucess(it)
                },
                {
                    onFailure(it as ErrorApp)
                })

        }
    }
    private fun onSucess(superheroes: List<SuperHeroe>){
        _uiState.value = UIState(isLoading = false, superheroes = superheroes)
    }

    private fun onFailure(error: ErrorApp){

    }

    data class UIState(
        val error: ErrorApp? = null,
        val isLoading: Boolean = false,
        val superheroes: List<SuperHeroe>? = null
    )


}