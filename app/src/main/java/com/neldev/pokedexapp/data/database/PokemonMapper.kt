package com.neldev.pokedexapp.data.database

import com.neldev.pokedexapp.data.pokemon_list.Pokemon

class PokemonMapper{
    fun fromRemoteToLocal(remotePokemon: Pokemon):PokemonEntity{
        return PokemonEntity(remotePokemon.name,remotePokemon.url)
    }
}