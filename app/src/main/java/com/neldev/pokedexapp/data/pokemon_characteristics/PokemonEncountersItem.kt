package com.neldev.pokedexapp.data.pokemon_characteristics

import com.google.gson.annotations.SerializedName

data class PokemonEncountersItem(
    @SerializedName("location_area")
    val locationArea: LocationArea?,
    @SerializedName("version_details")
    val versionDetails: List<Any?>?
)