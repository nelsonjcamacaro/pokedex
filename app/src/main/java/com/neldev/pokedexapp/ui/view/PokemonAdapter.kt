package com.neldev.pokedexapp.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neldev.pokedexapp.data.pokemon_list.Pokemon
import com.neldev.pokedexapp.databinding.MainCardViewBinding
import com.squareup.picasso.Picasso

class PokemonAdapter(private var pokemonList: List<Pokemon>, val listener:PokemonListener?= null) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    interface PokemonListener{
        fun onCLickPokemon(pokemon: Pokemon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MainCardViewBinding.inflate(layoutInflater, parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemonList[position])

    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun updatePokemon(pokemon: List<Pokemon>) {
        this.pokemonList = pokemon
        notifyDataSetChanged()
    }

    inner class PokemonViewHolder(private val binding: MainCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon) {
            val id = pokemon.url.substring(34).dropLast(1)
            val imgUrl =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
            binding.tvCardView.text = pokemon.name.replaceFirstChar(Char::titlecase)
            Picasso.get()
                .load(imgUrl)
                .into(binding.ivCardView)

            binding.root.setOnClickListener{
                listener?.onCLickPokemon(pokemon)
            }
        }
    }
}