package edu.iesam.superheroapi.features.superheroes.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.superheroapi.R
import edu.iesam.superheroapi.features.superheroes.core.api.ApiClient
import edu.iesam.superheroapi.features.superheroes.data.local.SuperheroDataRepository
import edu.iesam.superheroapi.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroapi.features.superheroes.domain.FetchSuperheroesUseCase
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

        val apiClient = ApiClient()
        val remoteDataSource = SuperHeroesApiRemoteDataSource(apiClient)
        val heroDataRepository = SuperheroDataRepository(remoteDataSource)
        val fetchSuperheroesUseCase = FetchSuperheroesUseCase(heroDataRepository)

        val viewModel = SuperHeroesListViewModel(fetchSuperheroesUseCase)
        viewModel.getSuperheroes().fold(
            onSuccess = { heroes ->
                heroes
            },
            onFailure = {
                emptyList<SuperHeroe>()
            }
        )

    }

}