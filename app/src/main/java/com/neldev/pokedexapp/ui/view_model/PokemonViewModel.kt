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

@HiltViewModel
class PokemonViewModel @Inject constructor(private val repository: PokemonRepository):ViewModel() {

    init {
        Log.d("MiTag", "en el init del viewModel")
        getPokemon()
    }


    val pokemon = MutableLiveData<PokemonResponse?>(null)

    private fun getPokemon(){
        viewModelScope.launch {
            val result = repository.getPokemon()
            pokemon.value = result
            Log.d("MiTag", "ViewModel")
        }
    }
}

class PokemonViewModelFactory @Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val repository: PokemonRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(repository) as T
    }
}