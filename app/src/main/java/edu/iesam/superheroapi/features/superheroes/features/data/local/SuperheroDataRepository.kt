package edu.iesam.superheroapi.features.superheroes.data.local

import edu.iesam.superheroapi.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroapi.features.superheroes.domain.SuperHeroe
import edu.iesam.superheroapi.features.superheroes.domain.SuperheroRepository

class SuperheroDataRepository (val superHeroesApiRemoteDataSource: SuperHeroesApiRemoteDataSource) : SuperheroRepository{
    override fun fetchSuperheroes(): Result<List<SuperHeroe>> {
        return superHeroesApiRemoteDataSource.getSuperHeroes()
    }


}