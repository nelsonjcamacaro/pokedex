package com.neldev.pokedexapp

import android.app.Application
import android.content.Context

class ContextClass:Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}