package com.neldev.pokedexapp.data

import com.neldev.pokedexapp.data.pokemon_characteristics.PokemonEncounters
import com.neldev.pokedexapp.data.pokemon_details.PokemonDetails
import com.neldev.pokedexapp.data.pokemon_evolution.PokemonEvolutionChain
import com.neldev.pokedexapp.data.pokemon_evolution.PokemonSpecies
import com.neldev.pokedexapp.data.pokemon_list.PokemonResponse

class PokemonRepository /*@Inject constructor(private val remoteDataSource: PokemonRemoteDataSource)*/
    (private val remoteDataSource: PokemonRemoteDataSource) {

    suspend fun getPokemon(): PokemonResponse? {
        return remoteDataSource.getPokemon()
    }

    suspend fun getPokemonDetails(pokemonId: String): PokemonDetails? {
        return remoteDataSource.getPokemonDetails(pokemonId)
    }

    suspend fun getPokemonEncounters(pokemonId:String): PokemonEncounters?{
        return remoteDataSource.getPokemonEncounters(pokemonId)
    }

    suspend fun getPokemonSpecies(pokemonId: String): PokemonSpecies?{
        return remoteDataSource.getPokemonSpecies(pokemonId)
    }

    suspend fun getPokemonEvolutionChain(pokemonChainId:String):PokemonEvolutionChain?{
        return remoteDataSource.getPokemonEvolutionChain(pokemonChainId)

    }

}