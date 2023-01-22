package com.neldev.pokedexapp.data.pokemon_characteristics

import com.google.gson.annotations.SerializedName

data class LocationArea(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)