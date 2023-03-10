package com.neldev.pokedexapp.data.network

import com.neldev.pokedexapp.data.pokemon_characteristics.PokemonEncounters
import com.neldev.pokedexapp.data.pokemon_details.PokemonDetails
import com.neldev.pokedexapp.data.pokemon_evolution.PokemonEvolutionChain
import com.neldev.pokedexapp.data.pokemon_evolution.PokemonSpecies
import com.neldev.pokedexapp.data.pokemon_list.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//@Component(modules = [NetworkModule::class])
interface GetPokemonService {

    @GET("api/v2/pokemon")
    fun getPokemon(@Query("limit")limit:Int,@Query("offset")offset:Int):Call<PokemonResponse>

    @GET("api/v2/pokemon/{id}")
    fun pokemonDetails(@Path("id")id:String):Call<PokemonDetails>

    @GET("api/v2/pokemon/{id}/encounters")
    fun getPokemonEncounters(@Path("id")id:String):Call<PokemonEncounters>

    @GET("api/v2/pokemon-species/{id}/")
    fun getPokemonSpecies(@Path("id")id:String):Call<PokemonSpecies>

    @GET("api/v2/evolution-chain/{id}/")
    fun getPokemonEvolutionChain(@Path("id")id:String):Call<PokemonEvolutionChain>
}