package com.neldev.pokedexapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.neldev.pokedexapp.R
import com.neldev.pokedexapp.databinding.ActivityDetailsBinding
import com.neldev.pokedexapp.ui.view_model.PokemonViewModel
import com.neldev.pokedexapp.ui.view_model.PokemonViewModelFactory
import com.squareup.picasso.Picasso
import java.util.stream.IntStream.range


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
        viewModel.getPokemonEncounters(pokemonId.toString())
        detailsRendering()
        encounterAreasRendering()
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
                for (i in pokemonDetails.abilities?.indices!!) {
                    abilities += pokemonDetails.abilities?.get(i)?.ability?.name + ", "
                    Log.d("MINUEVOTAG","$abilities")
                }
                binding.tvDetails2.text = "*Abilities: ${abilities.dropLast(2)}"

                var  pokemonType = ""
                for (i in pokemonDetails.types?.indices!!){
                    pokemonType += pokemonDetails.types?.get(i)?.type?.name +", "
                }
                binding.tvDetails3.text = "*Types: ${pokemonType.dropLast(2)}"

                var pokemonMoves = ""
                for (i in (0..10)){
                    pokemonMoves += pokemonDetails.moves?.get(i)?.move?.name +", "
                }
                binding.tvDetails4.text = "*Moves: ${pokemonMoves.dropLast(2)}"


            } else {
                Log.d("MiTag", "detailsRendering:  NO ok ")
            }
        }
    }

    private fun encounterAreasRendering(){
        viewModel.pokemonEncounter.observe(this) { pokemonEncounters ->
            Log.d("MINUEVOTAG3", "$pokemonEncounters")
            if (pokemonEncounters != null) {
                var encounters = ""
                Log.d("MINUEVOTAG2","$encounters")
                for (i in pokemonEncounters.indices) {
                    encounters += pokemonEncounters[i].locationArea?.name + ", "
                    Log.d("MINUEVOTAG","$encounters")
                }
                if (pokemonEncounters.isEmpty()){
                    binding.tvDetails6.text = "*Encounters areas: "+getString(R.string.without_information)
                }else{
                    binding.tvDetails6.text = "*Encounters areas: ${encounters.dropLast(2)}"
                }
            }
        }
    }
}