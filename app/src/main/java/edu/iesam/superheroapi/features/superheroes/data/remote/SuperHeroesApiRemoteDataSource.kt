package edu.iesam.superheroapi.features.superheroes.data.remote

import edu.iesam.superheroapi.features.superheroes.domain.SuperHeroe

class SuperHeroesApiRemoteDataSource {

    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return Result.success(listOf(SuperHeroe("")))
    }
}