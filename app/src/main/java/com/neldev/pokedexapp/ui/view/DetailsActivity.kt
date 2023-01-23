package com.neldev.pokedexapp.ui.view

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
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
        viewModel.getPokemonSpecies(pokemonId.toString())
        detailsRendering()
        encounterAreasRendering()
        obtainEvolutionChainId()
        backButton()
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
                    Log.d("MINUEVOTAG", "$abilities")
                }
                binding.tvDetails3.text = "*Abilities: ${abilities.dropLast(2)}"

                var pokemonType = ""
                for (i in pokemonDetails.types?.indices!!) {
                    pokemonType += pokemonDetails.types?.get(i)?.type?.name + ", "
                }
                binding.tvDetails2.text = "*Types: ${pokemonType.dropLast(2)}"

                var pokemonMoves = ""
                for (i in pokemonDetails.moves?.indices!!) {
                    pokemonMoves += pokemonDetails.moves?.get(i)?.move?.name +"\n- "
                }
                binding.tvDetails4.text = "*Moves:\n- ${pokemonMoves.dropLast(2)}"


            } else {
                Log.d("MiTag", "detailsRendering:  NO ok ")
                binding.tvDetails4.text = getString(R.string.moves_empty)

            }
        }
    }

    private fun encounterAreasRendering() {
        viewModel.pokemonEncounter.observe(this) { pokemonEncounters ->
            if (pokemonEncounters != null) {
                var encounters = ""
                for (i in (pokemonEncounters.indices)) {
                    encounters += pokemonEncounters[i].locationArea?.name + "\n- "
                }
                if (pokemonEncounters.isEmpty()) {
                    binding.tvDetails6.text =
                        "*Encounters areas: " + getString(R.string.without_information)
                } else {
                    binding.tvDetails6.text = "*Encounters areas:\n- ${encounters.dropLast(2)}"
                }
            }else{
                binding.tvDetails6.text = getString(R.string.encountersArea_empty)
            }
        }
    }

    //this funtion it's to find the evolution Chain ID, because that it's different to normal Id
    private fun obtainEvolutionChainId() {
        Log.d("probando", "si me ejecuto")
        viewModel.pokemonSpecies.observe(this) { pokemonSpecies ->
            var evolutionChainId = ""
            if (pokemonSpecies != null) {
                evolutionChainId =
                    pokemonSpecies.evolutionChain?.url?.substring(42)?.dropLast(1).toString()
                Log.d("probando", "$evolutionChainId")
            }
            viewModel.getEvolutionChain(evolutionChainId)

        }
        evolutionChainRendering()
    }

    private fun evolutionChainRendering() {
        viewModel.pokemonEvolutionChain.observe(this) { pokemonEvolutionChain ->
            if (pokemonEvolutionChain != null) {

                if (pokemonEvolutionChain.chain?.evolvesTo?.get(0)?.evolvesTo?.isEmpty() == true){
                    var pokemonEvolution1 =
                    pokemonEvolutionChain.chain.evolvesTo[0]?.species?.name?.replaceFirstChar(Char::titlecase)
                    binding.tvDetails5.text = "*Final Evolution: $pokemonEvolution1"
                }else{
                    var pokemonEvolution2 =
                        pokemonEvolutionChain.chain?.evolvesTo?.get(0)?.evolvesTo?.get(0)?.species?.name?.replaceFirstChar(
                            Char::titlecase
                        )
                    binding.tvDetails5.text = "*Final Evolution: $pokemonEvolution2"
                }
            }else{
                binding.tvDetails5.text =  getString(R.string.final_evolution_empty)
            }
        }
    }

    private fun backButton(){
        binding.backButton.setOnClickListener {
            val intent = Intent(this@DetailsActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }
}