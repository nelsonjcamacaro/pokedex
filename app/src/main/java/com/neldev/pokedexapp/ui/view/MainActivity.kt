package com.neldev.pokedexapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neldev.pokedexapp.data.Pokemon
import com.neldev.pokedexapp.data.PokemonRemoteDataSource
import com.neldev.pokedexapp.data.PokemonRepository
import com.neldev.pokedexapp.databinding.ActivityMainBinding
import com.neldev.pokedexapp.ui.view_model.PokemonViewModel
import com.neldev.pokedexapp.ui.view_model.PokemonViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*@AndroidEntryPoint*/
class MainActivity /*@Inject constructor(
    val remoteDataSource: PokemonRemoteDataSource,
    val repository: PokemonRepository,
  //  private val viewModelFactory: PokemonViewModelFactory
)*/() : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //   private lateinit var viewModel:PokemonViewModel
    //   private val viewModel by viewModels<PokemonViewModel>()

    private val viewModel: PokemonViewModel by viewModels(
        factoryProducer = { PokemonViewModelFactory() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelObserve()
        recyclerViewInstance(binding.rvMain)
    }

    private fun recyclerViewInstance(recyclerId: RecyclerView) {
        recyclerId.layoutManager = LinearLayoutManager(this)
    }

    private fun viewModelObserve() {
        viewModel.pokemon.observe(this) { listOfPokemon ->
            if (listOfPokemon?.results != null) {

                val adapter = PokemonAdapter(listOfPokemon.results,object: PokemonAdapter.PokemonListener{
                    override fun onCLickPokemon(pokemon: Pokemon) {
                        Toast.makeText(this@MainActivity, pokemon.name,Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity,DetailsActivity::class.java)
                            .apply{ putExtra(DetailsActivity.KEY1,pokemon.url.substring(34).dropLast(1)) }
                        startActivity(intent)
                    }
                })
                binding.rvMain.adapter = adapter
                binding.editText.addTextChangedListener {
                    val pokemonFiltered = listOfPokemon.results.filter { pokemon ->
                        pokemon.name.lowercase().contains(it.toString())
                    }
                    adapter.updatePokemon(pokemonFiltered)
                }
            }
        }

    }
}