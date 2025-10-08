package edu.iesam.superheroapi.features.superheroes.domain

sealed class ErrorApp : Throwable(){

    object ServerError : ErrorApp()
    object APINotConnected : ErrorApp()

}