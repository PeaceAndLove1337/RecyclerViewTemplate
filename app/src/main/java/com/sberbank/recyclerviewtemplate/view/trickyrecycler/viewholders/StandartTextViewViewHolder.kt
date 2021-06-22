package com.sberbank.recyclerviewtemplate.view.trickyrecycler.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sberbank.recyclerviewtemplate.R

class StandartTextViewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val textView = itemView.findViewById<TextView>(R.id.text_field)
    fun bind(text:String){
       textView.text=text
    }
}