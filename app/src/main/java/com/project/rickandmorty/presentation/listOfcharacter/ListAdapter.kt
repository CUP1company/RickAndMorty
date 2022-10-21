package com.project.rickandmorty.presentation.listOfcharacter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.rickandmorty.data.domain.models.Characters
import com.project.rickandmorty.databinding.ItemCharactorBinding
import com.squareup.picasso.Picasso


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var myList = emptyList<Characters>()
    var onItemClick: ((List<Characters>) -> Unit)? = null


    inner class MyViewHolder(val binding: ItemCharactorBinding): RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(myList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemCharactorBinding
            .inflate(LayoutInflater
                .from(parent.context), parent, false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.name.text = myList[position].name
        Picasso.get().load(myList[position].image).into(holder.binding.storiesView)
        when(myList[position].status){
            "Alive" -> holder.binding.statusLifeBar.background.setTint(Color.argb(255,85, 204, 68))
            "Dead" -> holder.binding.statusLifeBar.background.setTint(Color.argb(255,214, 61, 46))
            else -> holder.binding.statusLifeBar.background.setTint(Color.argb(255,158, 158, 158))
        }
        holder.binding.stausOfLife.text = myList[position].status + " - "+ myList[position].species
        holder.binding.lastKnownInfo.text = myList[position].location.name
        holder.binding.firstSeeInfo.text = myList[position].origin.name
    }

    fun setData(newList: List<Characters>){
        myList = newList
        notifyDataSetChanged()
    }
}