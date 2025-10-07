package edu.iesam.superheroapi.features.superheroes.data.remote

import edu.iesam.superheroapi.features.superheroes.core.api.ApiClient
import edu.iesam.superheroapi.features.superheroes.core.api.SuperHeroApiService
import edu.iesam.superheroapi.features.superheroes.domain.SuperHeroe

class SuperHeroesApiRemoteDataSource (private val apiClient: ApiClient){

    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        //entran ApiModels
        //salen Models
//        val apiModel = SuperHeroApiModel() //este es el objeto del que llamamos del this
//        apiModel.toModel()
//        return Result.success(listOf(SuperHeroe("")))

        val apiService = apiClient.createService(SuperHeroApiService::class.java)
        apiService.findAll()

        return Result.success(listOf())
    }
}