package com.example.retrofit_1.ui.fragments

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit_1.R
import com.example.retrofit_1.data.models.Character
import com.example.retrofit_1.databinding.CharacterViewHolderBinding

class CharacterAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<CharacterAdapter.MyHolder>() {

    private var characters = ArrayList<Character>()

    interface OnItemClickListener {
        fun onItemClick(character: Character)
    }

    inner class MyHolder(val binding: CharacterViewHolderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CharacterViewHolderBinding.inflate(layoutInflater, parent, false)
        return MyHolder(binding)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val character: Character = characters.get(position)
        holder.binding.tvName.text = character.name

        Glide.with(holder.itemView).load(character.image).into(holder.binding.ivImage)

        holder.itemView.setOnClickListener {
            listener.onItemClick(character)
        }

        when (character.status) {
            "Alive" -> holder.binding.ivCirculo.setImageResource(R.drawable.circle_green)
            "Dead" -> holder.binding.ivCirculo.setImageResource(R.drawable.circle_red)
            else -> holder.binding.ivCirculo.setImageResource(R.drawable.circle_yellow)
        }
    }

    fun updateList(list: List<Character>) {
        characters.clear()
        characters.addAll(list)
        notifyDataSetChanged()
    }
}