package com.testsandroid.pokedex.fragments.pokemonList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.testsandroid.Pokemon
import com.testsandroid.pokedex.MainActivity
import com.testsandroid.pokedex.PokeAdapter
import com.testsandroid.pokedex.PokeTypes
import com.testsandroid.pokedex.databinding.FragmentItemListPokemonBinding
import com.testsandroid.pokedex.databinding.PokemonListItemBinding
import kotlinx.android.synthetic.main.fragment_item_list_pokemon.view.*


class ItemListPokemonFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = FragmentItemListPokemonBinding.inflate(inflater,container,false)
        val recyclerView = view.pokemonRecycler.pokemon_recycler
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PokeAdapter()
        recyclerView.adapter = adapter
        adapter.onItemClickListener = {
            Toast.makeText(requireActivity(),"Pokemon: "+it.name+". Pokemon tipo: "+it.type,Toast.LENGTH_SHORT).show()
        }


        val pokemonList = mutableListOf(
                Pokemon(1,"Ghastly",40,32,25,60,PokeTypes.FANTASMA),
                Pokemon(2,"Hunter",40,32,25,60,PokeTypes.FANTASMA),
                Pokemon(3,"Gengar",40,32,25,60,PokeTypes.FANTASMA),
                Pokemon(4,"Bulbasur",40,32,25,60,PokeTypes.PLANTA),
                Pokemon(5,"Ivysur",40,32,25,60,PokeTypes.PLANTA),
                Pokemon(6,"Venasur",40,32,25,60,PokeTypes.PLANTA),
                Pokemon(7,"Charmander",40,32,25,60,PokeTypes.FUEGO),
                Pokemon(8,"Charmeleon",40,32,25,60,PokeTypes.FUEGO),
                Pokemon(9,"Charizard",40,32,25,60,PokeTypes.FUEGO),
                Pokemon(10,"Alakazam",40,32,25,60,PokeTypes.PSIQUICO)

        )
        adapter.submitList(pokemonList)

        return view.root
    }
}