package com.example.databindingrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.databindingrecyclerview.databinding.RowItemBinding

class MainAdapter(val data: ArrayList<Data>, private val onClick : (data : Data, position : Int) -> Unit) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    class MainViewHolder(val binding: RowItemBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        val holder = MainViewHolder(RowItemBinding.bind(v))
        v.setOnClickListener{
            onClick.invoke(data[holder.adapterPosition], holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.data = data[position]
    }

    override fun getItemCount(): Int = data.size
}