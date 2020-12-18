package com.testsandroid.pokedex

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.testsandroid.Pokemon
import kotlinx.android.synthetic.main.pokemon_list_item.view.*


private val TAG = PokeAdapter::class.java.simpleName

class PokeAdapter() : ListAdapter<Pokemon, PokeAdapter.ViewHolder>(DiffCallback){

    companion object DiffCallback : DiffUtil.ItemCallback<Pokemon>(){
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {

            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem

        }

    }

    lateinit var onItemClickListener: (Pokemon) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(
                R.layout.pokemon_list_item,parent,false)

        val binding = inflater

        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PokeAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)

    }

    inner class ViewHolder(private val binding: View): RecyclerView.ViewHolder(binding.rootView){

        fun bind(pokemon: Pokemon){
            binding.id_pokemon.text = pokemon.id.toString()
            binding.poke_name.text = pokemon.name

            val imageId = when(pokemon.type){
                PokeTypes.AGUA -> R.drawable.water_type
                PokeTypes.ELECTRICO -> R.drawable.electric_type
                PokeTypes.FANTASMA -> R.drawable.ghost_type
                PokeTypes.FUEGO -> R.drawable.fire_type
                PokeTypes.LUCHADOR -> R.drawable.fighting_type
                PokeTypes.PLANTA -> R.drawable.grass_type
                PokeTypes.PSIQUICO -> R.drawable.psychic_type
            }
            binding.pokemon_type.setImageResource(imageId)



            binding.rootView.setOnClickListener{
                if(::onItemClickListener.isInitialized){
                    onItemClickListener(pokemon)
                }else{
                    Log.i(TAG, "OnItemCLickListener not initialized")
                }


            }


        }
    }


}

