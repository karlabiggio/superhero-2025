package edu.iesam.superheroapi.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.superheroapi.features.superheroes.domain.FetchSuperheroesUseCase
import edu.iesam.superheroapi.features.superheroes.domain.SuperHeroe

class SuperHeroesListViewModel (val fetchSuperheroesUseCase: FetchSuperheroesUseCase) : ViewModel(){

    fun getSuperheroes() : Result<List<SuperHeroe>>{
        return fetchSuperheroesUseCase.invoke()
    }

}