package com.neldev.pokedexapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.neldev.pokedexapp.databinding.ActivityDetailsBinding
import com.neldev.pokedexapp.ui.view_model.PokemonViewModel
import com.neldev.pokedexapp.ui.view_model.PokemonViewModelFactory
import com.squareup.picasso.Picasso


//@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private val viewModel: PokemonViewModel by viewModels(
        factoryProducer = { PokemonViewModelFactory() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pokemonId = intent.getStringExtra(KEY1)


        uploadPokemonImg(pokemonId.toString())

        viewModel.getPokemonDetails(pokemonId.toString())

        detailsRendering()
    }

    companion object {
        const val KEY1 = "Id of pokemon"
    }

    private fun uploadPokemonImg(id: String?) {
        val imgUrlBase =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
        Picasso.get()
            .load(imgUrlBase)
            .into(binding.ivDetails)
    }

    private fun detailsRendering() {
        viewModel.pokemonDetails.observe(this) { pokemonDetails ->
            if (pokemonDetails != null) {
                Log.d("MiTag", "detailsRendering: ok ")
                binding.tvDetails1.text = pokemonDetails.name?.replaceFirstChar(Char::titlecase)
                var abilities = ""
                    for(i in pokemonDetails.abilities?.indices!!){
                    abilities += pokemonDetails.abilities?.get(i)?.ability?.name + ", "
                }
                binding.tvDetails2.text = "Abilities: ${abilities.dropLast(2)}"

                binding.tvDetails3.text = pokemonDetails.locationAreaEncounters

            } else {
                Log.d("MiTag", "detailsRendering:  NO ok ")
            }
        }
    }
}