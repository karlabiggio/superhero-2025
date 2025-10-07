package edu.iesam.superheroapi.features.superheroes.data.remote

import edu.iesam.superheroapi.features.superheroes.domain.SuperHeroe

fun SuperHeroApiModel.toModel() : SuperHeroe{
    return SuperHeroe(this.id,
        this.name,
        this.slug,
        this.images.md)

}