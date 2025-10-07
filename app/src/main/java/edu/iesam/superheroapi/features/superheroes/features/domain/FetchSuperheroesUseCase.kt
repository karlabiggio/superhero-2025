package edu.iesam.superheroapi.features.superheroes.domain

import edu.iesam.superheroapi.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource

class FetchSuperheroesUseCase(private val superheroRepository: SuperheroRepository) {

    operator fun invoke() : Result<List<SuperHeroe>>{
        val superheroes : List<SuperHeroe> = superheroRepository.fetchSuperheroes()
        if(!superheroes.isEmpty()){
            return Result.success(superheroes)
        }else {
            return Result.failure(ErrorApp.APINotConnected)
        }
    }

}










