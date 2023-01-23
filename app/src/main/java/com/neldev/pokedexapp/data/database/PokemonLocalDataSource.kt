package com.neldev.pokedexapp.data.database

import android.content.Context
import androidx.room.Room

class PokemonLocalDataSource(context: Context) {
    private val db =
        Room.databaseBuilder(context, PokemonDatabase::class.java, "pokemon-data-base").build()

    suspend fun getPokemonFromDao():List<PokemonEntity> = db.pokemonDao().getAllPokemon()
    suspend fun insertPokemonFromAPI(pokemonEntity: PokemonEntity) = db.pokemonDao().insertAllPokemon()
    suspend fun updatePokemon(pokemonEntity: PokemonEntity) = db.pokemonDao().updatePokemon()
    suspend fun deletePokemon(pokemonEntity: PokemonEntity)= db.pokemonDao().deletePokemon()

}