package com.neldev.pokedexapp.ui.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.neldev.pokedexapp.ContextClass.Companion.context
import com.neldev.pokedexapp.data.*
import com.neldev.pokedexapp.data.database.PokemonLocalDataSource
import com.neldev.pokedexapp.data.network.PokemonRemoteDataSource
import com.neldev.pokedexapp.data.pokemon_characteristics.PokemonEncounters
import com.neldev.pokedexapp.data.pokemon_details.PokemonDetails
import com.neldev.pokedexapp.data.pokemon_evolution.PokemonEvolutionChain
import com.neldev.pokedexapp.data.pokemon_evolution.PokemonSpecies
import com.neldev.pokedexapp.data.pokemon_list.PokemonResponse
import kotlinx.coroutines.launch

/*@HiltViewModel*/
class PokemonViewModel(private val repository: PokemonRepository) : ViewModel() {

    val pokemon = MutableLiveData<PokemonResponse?>(null)
    val pokemonDetails = MutableLiveData<PokemonDetails?>(null)
    val pokemonEncounter = MutableLiveData<PokemonEncounters?>(null)
    val pokemonSpecies = MutableLiveData<PokemonSpecies?>(null)
    val pokemonEvolutionChain = MutableLiveData<PokemonEvolutionChain?>(null)

    init {
        getPokemon()
    }

    private fun getPokemon() {
        viewModelScope.launch {
            val result = repository.getPokemon()
            pokemon.value = result
            //repository.insertPokemonInDao(result)
        }
    }

    fun getPokemonDetails(pokemonId: String) {
        viewModelScope.launch {
            val result = repository.getPokemonDetails(pokemonId)
            pokemonDetails.value = result
        }
    }

    fun getPokemonEncounters(pokemonId: String) {
        viewModelScope.launch {
            val result = repository.getPokemonEncounters(pokemonId)
            pokemonEncounter.value = result
        }
    }

    fun getPokemonSpecies(pokemonId: String) {
        viewModelScope.launch {
            val result = repository.getPokemonSpecies(pokemonId)
            pokemonSpecies.value = result
        }
    }

    fun getEvolutionChain(pokemonChainId:String){
        viewModelScope.launch {
            val result = repository.getPokemonEvolutionChain(pokemonChainId)
            pokemonEvolutionChain.value = result
        }
    }
}

class PokemonViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val remoteDataSource = PokemonRemoteDataSource()
        //val localDataSource = PokemonLocalDataSource(context)
        val repository = PokemonRepository(remoteDataSource)

        return PokemonViewModel(repository) as T
    }
}