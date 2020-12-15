package com.testsandroid.pokedex.fragments.pokemonList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.testsandroid.pokedex.R
import com.testsandroid.pokedex.databinding.FragmentItemListPokemonBinding
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


        return view.root
    }


}