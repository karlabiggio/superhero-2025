package edu.iesam.superheroapi.features.superheroes.data.remote

import edu.iesam.superheroapi.features.superheroes.core.api.ApiClient
import edu.iesam.superheroapi.features.superheroes.features.data.remote.SuperHeroApiService
import edu.iesam.superheroapi.features.superheroes.domain.ErrorApp
import edu.iesam.superheroapi.features.superheroes.domain.SuperHeroe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class SuperHeroesApiRemoteDataSource (private val apiClient: ApiClient) {

    suspend fun getSuperHeroes(): Result<List<SuperHeroe>> {
        //entran ApiModels
        //salen Models
//        val apiModel = SuperHeroApiModel() //este es el objeto del que llamamos del this
//        apiModel.toModel()
//        return Result.success(listOf(SuperHeroe("")))
        return withContext(Dispatchers.IO) {
            val apiService = apiClient.createService(SuperHeroApiService::class.java)
            val resultSuperHero = apiService.findAll()
            if (resultSuperHero.isSuccessful && resultSuperHero.errorBody() == null) {
                val listSuperHeroApiModel: List<SuperHeroApiModel> = resultSuperHero.body()!!
                val listSuperHero = listSuperHeroApiModel.map { superHeroApiModel ->
                    superHeroApiModel.toModel()
                }
                Result.success(listSuperHero)

//            return Result.success(resultSuperHero.body()!!.map {
//                it.toModel()
//            })
            } else {
                Result.failure(ErrorApp.ServerError)
            }
        }
    }
}