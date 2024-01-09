package com.example.retrofit_1.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.retrofit_1.databinding.ChapterHolderBinding

class ChaptersAdapter(val list: List<String>) : RecyclerView.Adapter<ChaptersAdapter.MyHolder>() {

    inner class MyHolder(val binding: ChapterHolderBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ChapterHolderBinding.inflate(layoutInflater, parent, false)
        return MyHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val url = list[position]
        val number = url?.substringAfterLast("/")

        holder.binding.tvChapter.text = "Episodio $number"
    }


}