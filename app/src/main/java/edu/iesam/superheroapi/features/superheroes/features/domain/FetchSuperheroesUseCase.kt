package edu.iesam.superheroapi.features.superheroes.domain

import edu.iesam.superheroapi.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource

class FetchSuperheroesUseCase(private val superheroRepository: SuperheroRepository) {

    suspend operator fun invoke() : Result<List<SuperHeroe>>{
        return superheroRepository.fetchSuperheroes()
        }

}










