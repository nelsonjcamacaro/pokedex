package com.neldev.pokedexapp.data

import com.neldev.pokedexapp.core.NetworkModule
import dagger.Component
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//@Component(modules = [NetworkModule::class])
interface GetPokemonService {

    @GET("api/v2/pokemon")
    suspend fun getPokemon(@Query("limit")limit:Int,@Query("offset")offset:Int):Call<PokemonResponse>

}