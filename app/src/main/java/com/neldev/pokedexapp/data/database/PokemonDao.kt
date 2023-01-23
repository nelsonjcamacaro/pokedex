package com.neldev.pokedexapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface PokemonDao {
    @Query("SELECT * FROM PokemonEntity")
    fun getAllPokemon(): List<PokemonEntity>

    @Insert
    fun insertAllPokemon(vararg pokemon: PokemonEntity)

    @Delete
    fun deletePokemon(vararg pokemon:PokemonEntity)

    @Update
    fun updatePokemon(vararg pokemon: PokemonEntity)
}