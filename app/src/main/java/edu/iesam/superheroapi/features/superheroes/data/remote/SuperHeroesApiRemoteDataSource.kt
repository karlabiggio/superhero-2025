package edu.iesam.superheroapi.features.superheroes.data.remote

import edu.iesam.superheroapi.features.superheroes.domain.SuperHeroe

class SuperHeroesApiRemoteDataSource {

    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return Result.success(listOf(SuperHeroe(
            id = "1",
            name = "Spider-Man",
            slug = "spider-man",
            urlImage = "https://static.wikia.nocookie.net/marveldatabase/images/0/0d/Amazing_Fantasy_Vol_1_15.jpg"
        ),
            SuperHeroe(
                id = "2",
                name = "Wonder Woman",
                slug = "wonder-woman",
                urlImage = "https://static.wikia.nocookie.net/dcmovies/images/7/7d/Wonder_Woman_1984_Poster.jpg"
            ),
            SuperHeroe(
                id = "3",
                name = "Batman",
                slug = "batman",
                urlImage = "https://static.wikia.nocookie.net/batman/images/8/84/Batman_DC_Comics.png"
            )))
    }
}