package com.testsandroid

import com.testsandroid.pokedex.PokeTypes

data class Pokemon(
    val id: Long,
    val name:String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val type: PokeTypes
)
