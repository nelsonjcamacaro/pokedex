package com.neldev.pokedexapp.data

import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class PokemonResponse(
    @SerializedName("count") val count:Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: Any,
    @SerializedName("results") val results: List<Pokemon>
)
