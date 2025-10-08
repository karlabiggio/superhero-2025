package edu.iesam.superheroapi.features.superheroes.presentation

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroapi.features.superheroes.domain.FetchSuperheroesUseCase
import edu.iesam.superheroapi.features.superheroes.domain.SuperheroRepository
import kotlinx.coroutines.launch

class SuperHeroesListViewModel(private val useCase: FetchSuperheroesUseCase): ViewModel(){

    fun loadSuperHeroes() {
        viewModelScope.launch {
            useCase.invoke()
        }
    }


}