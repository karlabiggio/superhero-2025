package edu.iesam.superheroapi.features.superheroes.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.superheroapi.R
import edu.iesam.superheroapi.features.superheroes.data.local.SuperheroDataRepository
import edu.iesam.superheroapi.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroapi.features.superheroes.domain.FetchSuperheroesUseCase
import edu.iesam.superheroapi.features.superheroes.domain.PruebaSuperheroe
import edu.iesam.superheroapi.features.superheroes.domain.SuperHeroe
import edu.iesam.superheroapi.features.superheroes.domain.SuperheroRepository

class SuperHeroesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getSuperheroes()
    }

    fun getSuperheroes() {
        val remoteDataSource = SuperHeroesApiRemoteDataSource()
        val heroRepository = PruebaSuperheroe(remoteDataSource)
        val fetchSuperheroesUseCase = FetchSuperheroesUseCase(heroRepository)
        val heroResult: Result<List<SuperHeroe>> = fetchSuperheroesUseCase.invoke()

        return heroResult.fold(
            onSuccess = { heroes ->
                heroes },
            onFailure = {
                emptyList<SuperHeroe>() }
        )

    }

}