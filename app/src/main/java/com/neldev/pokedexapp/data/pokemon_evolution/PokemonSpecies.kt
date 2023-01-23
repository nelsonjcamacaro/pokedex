package com.neldev.pokedexapp.data.pokemon_evolution


import com.google.gson.annotations.SerializedName

data class PokemonSpecies(
    @SerializedName("base_happiness")
    val baseHappiness: Int?,
    @SerializedName("capture_rate")
    val captureRate: Int?,
    @SerializedName("color")
    val color: Color?,
    @SerializedName("egg_groups")
    val eggGroups: List<Any?>?,
    @SerializedName("evolution_chain")
    val evolutionChain: EvolutionChain?,
    @SerializedName("evolves_from_species")
    val evolvesFromSpecies: EvolvesFromSpecies?,
    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<Any?>?,
    @SerializedName("form_descriptions")
    val formDescriptions: List<Any?>?,
    @SerializedName("forms_switchable")
    val formsSwitchable: Boolean?,
    @SerializedName("gender_rate")
    val genderRate: Int?,
    @SerializedName("genera")
    val genera: List<Any?>?,
    @SerializedName("generation")
    val generation: Generation?,
    @SerializedName("growth_rate")
    val growthRate: GrowthRate?,
    @SerializedName("habitat")
    val habitat: Habitat?,
    @SerializedName("has_gender_differences")
    val hasGenderDifferences: Boolean?,
    @SerializedName("hatch_counter")
    val hatchCounter: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("is_baby")
    val isBaby: Boolean?,
    @SerializedName("is_legendary")
    val isLegendary: Boolean?,
    @SerializedName("is_mythical")
    val isMythical: Boolean?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("names")
    val names: List<Any?>?,
    @SerializedName("order")
    val order: Int?,
    @SerializedName("pal_park_encounters")
    val palParkEncounters: List<Any?>?,
    @SerializedName("pokedex_numbers")
    val pokedexNumbers: List<Any?>?,
    @SerializedName("shape")
    val shape: Shape?,
    @SerializedName("varieties")
    val varieties: List<Any?>?
)

class Color

data class EvolutionChain(
    @SerializedName("url")
    val url: String?
)

class EvolvesFromSpecies

class Generation

class GrowthRate

class Habitat

class Shape