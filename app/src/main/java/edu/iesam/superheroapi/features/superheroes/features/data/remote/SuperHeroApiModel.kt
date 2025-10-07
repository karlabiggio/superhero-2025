package edu.iesam.superheroapi.features.superheroes.data.remote

data class SuperHeroApiModel(
    val id: String,
    val name: String,
    val slug: String,
    val images: SuperHeroImageApiModel
)
data class SuperHeroImageApiModel(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)
