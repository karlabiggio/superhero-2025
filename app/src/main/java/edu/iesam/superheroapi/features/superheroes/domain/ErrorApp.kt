package edu.iesam.superheroapi.features.superheroes.domain

sealed class ErrorApp : Throwable(){

    object SuperheroNotFound : ErrorApp()
    object APINotConnected : ErrorApp()

}