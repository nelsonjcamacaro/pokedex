package com.neldev.pokedexapp.data.pokemon_evolution

import com.google.gson.annotations.SerializedName

data class PokemonEvolutionChain(
    @SerializedName("baby_trigger_item")
    val babyTriggerItem: Any?,
    @SerializedName("chain")
    val chain: Chain?,
    @SerializedName("id")
    val id: Int?
)

data class Chain(
    @SerializedName("evolution_details")
    val evolutionDetails: List<Any?>?,
    @SerializedName("evolves_to")
    val evolvesTo: List<EvolvesTo?>?,
    @SerializedName("is_baby")
    val isBaby: Boolean?,
    @SerializedName("species")
    val species: Species?
)

data class EvolvesTo(
    @SerializedName("evolution_details")
    val evolutionDetails: List<Any?>?,
    @SerializedName("evolves_to")
    val evolvesTo: List<EvolvesTo?>?,
    @SerializedName("is_baby")
    val isBaby: Boolean?,
    @SerializedName("species")
    val species: Species?
)

data class Species(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)