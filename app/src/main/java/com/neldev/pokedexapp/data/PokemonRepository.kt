package com.neldev.pokedexapp.data

import android.util.Log
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val remoteDataSource: PokemonRemoteDataSource) {

    suspend fun getPokemon(): PokemonResponse?{
        Log.d("MiTag", "repository")
        return remoteDataSource.getTopRatedMovies()
    }
}