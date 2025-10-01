package edu.iesam.superheroapi.features.superheroes.data.remote

class SuperHeroesApiRemoteDataSource {

    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return Result.success(listOf(SuperHeroe("")))
    }
}