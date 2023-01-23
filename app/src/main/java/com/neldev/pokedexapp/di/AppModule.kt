package com.neldev.pokedexapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //okhttp Provider
/*    @Singleton
    @Provides
    fun provideOkhttp():OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    // Gson Converter Provider
    @Singleton
    @Provides
    fun provideGson(): GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    //Retrofit Provider
    @Singleton
    @Provides
    fun provideRetrofitService(httpClient:OkHttpClient, gson:GsonConverterFactory):Retrofit{

        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .addConverterFactory(gson)
            .client(httpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit:Retrofit):GetPokemonService {
       return retrofit.create(GetPokemonService::class.java)
    }

    @Singleton
    @Provides
    fun provideViewModelFactory() = ViewModelProvider.Factory

    @Singleton
    @Provides
    fun provideRemoteDataSource(api:GetPokemonService) = PokemonRemoteDataSource()

    @Singleton
    @Provides
    fun provideRepository(dataSource: PokemonRemoteDataSource) = PokemonRepository(dataSource)

    @Singleton
    @Provides
    fun provideViewModel(repo:PokemonRepository) = PokemonViewModel(repo)
*/
}