package edu.iesam.superheroapi.features.superheroes.presentation

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroapi.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroapi.features.superheroes.domain.FetchSuperheroesUseCase
import edu.iesam.superheroapi.features.superheroes.domain.SuperheroRepository
import kotlinx.coroutines.launch

class SuperHeroesListViewModel(private val dataSource: SuperHeroesApiRemoteDataSource): ViewModel(){

    fun loadSuperHeroes() {
        viewModelScope.launch {
            val superHeroes = dataSource.getSuperHeroes()
        }
    }


}