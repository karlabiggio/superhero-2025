package edu.iesam.superheroapi.features.superheroes.features.data.remote

import edu.iesam.superheroapi.features.superheroes.data.remote.SuperHeroApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroApiService {
    @GET("all.json")
    suspend fun findAll(): Response<List<SuperHeroApiModel>>

    @GET("id/{superheroId}.json")
    fun findById(@Path("superheroId") id: String): SuperHeroApiModel



}