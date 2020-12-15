package com.testsandroid.pokedex

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.testsandroid.Pokemon
import com.testsandroid.pokedex.databinding.FragmentItemListPokemonBinding


private val TAG = PokeAdapter::class.java.simpleName

class PokeAdapter(private val context: Context): ListAdapter<Pokemon, PokeAdapter.ViewHolder>(DiffCallback){

    companion object DiffCallback : DiffUtil.ItemCallback<Pokemon>(){
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {

            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeAdapter.ViewHolder {

        val binding = FragmentItemListPokemonBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokeAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)

    }

    inner class ViewHolder(private val binding: FragmentItemListPokemonBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(pokemon: Pokemon){


        }
    }

    }

