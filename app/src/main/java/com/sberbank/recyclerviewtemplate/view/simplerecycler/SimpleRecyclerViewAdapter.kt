package com.sberbank.recyclerviewtemplate.view.simplerecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sberbank.recyclerviewtemplate.R

/**
 * Simple recycler with only one type views
 */
class SimpleRecyclerViewAdapter: RecyclerView.Adapter<SimpleRecyclerViewAdapter.SomeViewHolder>() {

    // Some items...
    private var items = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SomeViewHolder {
        return SomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.some_textview_item, parent, false))
    }

    override fun onBindViewHolder(holder: SomeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return  items.size
    }

    fun setContent(){
        items= arrayListOf("HELLO", "WORLD", "HELLO", "WORLD", "HELLO", "WORLD", "HELLO", "WORLD",
            "HELLO", "WORLD", "HELLO", "WORLD", "HELLO", "WORLD","HELLO", "WORLD","HELLO", "WORLD",
            "HELLO", "WORLD","HELLO", "WORLD","HELLO", "WORLD","HELLO", "WORLD","HELLO", "WORLD","HELLO", "WORLD",
            "HELLO", "WORLD","HELLO", "WORLD","HELLO", "WORLD","HELLO", "WORLD","HELLO", "WORLD","HELLO", "WORLD")
    }

    class SomeViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(text:String) {
            itemView.findViewById<TextView>(R.id.text_field).text=text
        }
    }


}