package com.neldev.pokedexapp.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(private val api: GetPokemonService) {

   suspend fun getTopRatedMovies(): PokemonResponse?{
       Log.d("MiTag", "apenas llego aqui")
        return withContext(Dispatchers.IO){
            try {
                val response: Response<PokemonResponse?> = api.getPokemon(151,0).awaitResponse()
                val pokemonResponse = response.body()
                Log.d("MiTag", "en el remote salio ok")
                pokemonResponse
            }catch (e:Exception){
                Log.d("MiTag", "remote con exception")
                null
            }
        }
   }
}

