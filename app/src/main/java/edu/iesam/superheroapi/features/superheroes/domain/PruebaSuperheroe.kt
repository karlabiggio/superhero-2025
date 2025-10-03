package edu.iesam.superheroapi.features.superheroes.domain

import edu.iesam.superheroapi.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource

class PruebaSuperheroe(private val remoteDataSource: SuperHeroesApiRemoteDataSource): SuperheroRepository
    {
        override fun fetchSuperheroes(): List<SuperHeroe> {
            return remoteDataSource.getSuperHeroes().getOrElse { emptyList() }
        }

    }
