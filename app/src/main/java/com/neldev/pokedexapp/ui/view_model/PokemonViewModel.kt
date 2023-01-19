package com.neldev.pokedexapp.ui.view_model

import androidx.lifecycle.ViewModel
import com.neldev.pokedexapp.data.PokemonRepository
import com.neldev.pokedexapp.data.PokemonResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val repository: PokemonRepository):ViewModel() {
    
}