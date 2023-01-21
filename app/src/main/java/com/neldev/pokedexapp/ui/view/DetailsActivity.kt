package com.neldev.pokedexapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neldev.pokedexapp.R
import com.neldev.pokedexapp.databinding.ActivityDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


//@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object{
        const val KEY1 ="Id of pokemon"
    }
}