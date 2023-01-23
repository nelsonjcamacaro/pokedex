package com.neldev.pokedexapp.data

import android.util.Log
import com.neldev.pokedexapp.data.pokemon_characteristics.PokemonEncounters
import com.neldev.pokedexapp.data.pokemon_details.PokemonDetails
import com.neldev.pokedexapp.data.pokemon_evolution.PokemonEvolutionChain
import com.neldev.pokedexapp.data.pokemon_evolution.PokemonSpecies
import com.neldev.pokedexapp.data.pokemon_list.PokemonResponse
import com.neldev.pokedexapp.di.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.awaitResponse

class PokemonRemoteDataSource /*@Inject constructor(private val api: GetPokemonService)*/ {

    /* suspend fun getPokemon(): PokemonResponse?{
         Log.d("MiTag", "apenas llego aqui")
          return withContext(Dispatchers.IO){
              try {
                  val response: Response<PokemonResponse?> = api.getPokemon(10,0).awaitResponse()
                  val pokemonResponse = response.body()
                  Log.d("MiTag", "en el remote salio ok")
                  pokemonResponse
              }catch (e:Exception){
                  Log.d("MiTag", "remote con exception")
                  null
              }
          }
     }*/

    suspend fun getPokemon(): PokemonResponse? {
        val listLimit = 151
        val listOffset = 0
        val service = RetrofitService.instance.create(GetPokemonService::class.java)
            .getPokemon(listLimit, listOffset)

        return withContext(Dispatchers.IO) {
            try {
                val response: Response<PokemonResponse> = service.awaitResponse()
                val pokemonResponse = response.body()
                pokemonResponse
            } catch (e: Exception) {
                null
            }
        }
    }

    suspend fun getPokemonDetails(pokemonId: String): PokemonDetails? {
        val service = RetrofitService.instance.create(GetPokemonService::class.java).pokemonDetails(
            pokemonId
        )

        return withContext(Dispatchers.IO) {
            try {
                val response: Response<PokemonDetails> = service.awaitResponse()
                val pokemonDetailsResponse = response.body()
                Log.d("MiTag", "details RemoteData: ok ")
                pokemonDetailsResponse
            } catch (e: Exception) {
                Log.d("MiTag", "details RemoteData:  NO ok ")
                null
            }
        }
    }

    suspend fun getPokemonEncounters(pokemonId: String): PokemonEncounters? {
        val service =
            RetrofitService.instance.create(GetPokemonService::class.java).getPokemonEncounters(
                pokemonId
            )

        return withContext(Dispatchers.IO) {
            try {
                val response: Response<PokemonEncounters> = service.awaitResponse()
                val pokemonEncountersResponse = response.body()
                pokemonEncountersResponse
            } catch (e: Exception) {
                null
            }
        }
    }

    suspend fun getPokemonSpecies(pokemonId: String):PokemonSpecies? {
        val service =
            RetrofitService.instance.create(GetPokemonService::class.java).getPokemonSpecies(
                pokemonId
            )

        return withContext(Dispatchers.IO) {
            try {
                val response: Response<PokemonSpecies> = service.awaitResponse()
                val pokemonSpeciesResponse = response.body()
                pokemonSpeciesResponse
            } catch (e: Exception) {
                null
            }
        }
    }

    suspend fun getPokemonEvolutionChain(pokemonChainId: String):PokemonEvolutionChain? {
        val service =
            RetrofitService.instance.create(GetPokemonService::class.java).getPokemonEvolutionChain(
                pokemonChainId
            )

        return withContext(Dispatchers.IO) {
            try {
                val response: Response<PokemonEvolutionChain> = service.awaitResponse()
                val pokemonEvolutionChainResponse = response.body()
                pokemonEvolutionChainResponse
            } catch (e: Exception) {
                null
            }
        }
    }
}

