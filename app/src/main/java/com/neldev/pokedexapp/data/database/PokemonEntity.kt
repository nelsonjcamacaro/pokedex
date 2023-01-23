package com.neldev.pokedexapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    @PrimaryKey
    @ColumnInfo(name = "name") val  name: String,
    @ColumnInfo(name = "url") val url: String
)
