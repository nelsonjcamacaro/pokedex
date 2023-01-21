package com.neldev.pokedexapp.data

import android.util.Log
import com.neldev.pokedexapp.data.pokemon_details.PokemonDetails
import javax.inject.Inject

class PokemonRepository /*@Inject constructor(private val remoteDataSource: PokemonRemoteDataSource)*/
    (private val remoteDataSource: PokemonRemoteDataSource) {

    suspend fun getPokemon(): PokemonResponse?{
        return remoteDataSource.getPokemon()
    }

    suspend fun getPokemonDetails(pokemonId:String):PokemonDetails?{
        return remoteDataSource.getPokemonDetails(pokemonId)
    }
}