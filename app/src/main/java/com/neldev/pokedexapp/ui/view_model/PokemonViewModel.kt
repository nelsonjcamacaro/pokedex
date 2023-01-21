package com.neldev.pokedexapp.ui.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.neldev.pokedexapp.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*@HiltViewModel*/
class PokemonViewModel(private val repository: PokemonRepository) : ViewModel() {

    val pokemon = MutableLiveData<PokemonResponse?>(null)
    init {
        getPokemon()
    }

    private fun getPokemon() {
        viewModelScope.launch {
            Log.d("MiTag", "ViewModel")
            val result = repository.getPokemon()
            Log.d("MiTag", "$result")
            pokemon.value = result
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