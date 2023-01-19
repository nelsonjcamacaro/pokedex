package com.neldev.pokedexapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(private val api: GetPokemonService) {

   suspend fun getTopRatedMovies(): PokemonResponse?{
       // val service = RetrofitService.instance.create(GetMovieService::class.java).getTopRatedMovies(BuildConfig.API_KEY)

        return withContext(Dispatchers.IO){
            try {
                val response: Response<PokemonResponse> = api.getPokemon(151,0).awaitResponse()
                val pokemonResponse = response.body()
                pokemonResponse
            }catch (e:Exception){
                null
            }
        }
   }
}

