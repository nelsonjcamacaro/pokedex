package com.neldev.pokedexapp.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.neldev.pokedexapp.data.*
import com.neldev.pokedexapp.data.pokemon_details.PokemonDetails
import kotlinx.coroutines.launch

/*@HiltViewModel*/
class PokemonViewModel(private val repository: PokemonRepository) : ViewModel() {

    val pokemon = MutableLiveData<PokemonResponse?>(null)
    val pokemonDetails = MutableLiveData<PokemonDetails?>(null)
    init {
        getPokemon()
    }

    private fun getPokemon() {
        viewModelScope.launch {
            val result = repository.getPokemon()
            pokemon.value = result
        }
    }

    fun getPokemonDetails(pokemonId:String){
        viewModelScope.launch {
            val result = repository.getPokemonDetails(pokemonId)
            pokemonDetails.value = result
        }
    }
}

class PokemonViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val remoteDataSource = PokemonRemoteDataSource()
        val repository = PokemonRepository(remoteDataSource)

        return PokemonViewModel(repository) as T
    }
}