package com.neldev.pokedexapp.data

import com.neldev.pokedexapp.data.pokemon_details.PokemonDetails
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
}