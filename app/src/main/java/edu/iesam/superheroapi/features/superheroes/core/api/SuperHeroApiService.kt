package edu.iesam.superheroapi.features.superheroes.core.api

import edu.iesam.superheroapi.features.superheroes.data.remote.SuperHeroApiModel
import retrofit2.http.GET
import retrofit2.http.Path


interface SuperHeroApiService {
    @GET("all.json")
    fun findAll(): List<SuperHeroApiModel>

    @GET("id/{superheroId}.json")
    fun findById(@Path("superheroId") id: String): SuperHeroApiModel



}