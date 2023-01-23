package com.neldev.pokedexapp.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.neldev.pokedexapp.ContextClass.Companion.context
import com.neldev.pokedexapp.data.database.PokemonEntity
import com.neldev.pokedexapp.data.database.PokemonLocalDataSource
import com.neldev.pokedexapp.data.database.PokemonMapper
import com.neldev.pokedexapp.data.network.PokemonRemoteDataSource
import com.neldev.pokedexapp.data.pokemon_characteristics.PokemonEncounters
import com.neldev.pokedexapp.data.pokemon_details.PokemonDetails
import com.neldev.pokedexapp.data.pokemon_evolution.PokemonEvolutionChain
import com.neldev.pokedexapp.data.pokemon_evolution.PokemonSpecies
import com.neldev.pokedexapp.data.pokemon_list.Pokemon
import com.neldev.pokedexapp.data.pokemon_list.PokemonResponse

class PokemonRepository /*@Inject constructor(private val remoteDataSource: PokemonRemoteDataSource)*/
    (private val remoteDataSource: PokemonRemoteDataSource/*, private val localDataSource: PokemonLocalDataSource*/) {

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



    // the next function its to use room database, but needs modifications, as an integrate the mapper

    //val pokemonMapper = PokemonMapper()


   /* suspend fun getPokemonToMainScreen():Any?{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

        return if (networkInfo != null && networkInfo.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)){
            remoteDataSource.getPokemon()
        }else{
            localDataSource.getPokemonFromDao()
        }
    }

    suspend fun insertPokemonInDao(pokemonEntity: PokemonEntity){
        localDataSource.insertPokemonFromAPI(pokemonEntity)
    }*/

}





















