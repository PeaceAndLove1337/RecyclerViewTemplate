package com.sberbank.recyclerviewtemplate.view.trickyrecycler.viewholders

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.sberbank.recyclerviewtemplate.R

class StandartButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val button = itemView.findViewById<Button>(R.id.button)

    fun bind(text: String, onClickListener: View.OnClickListener) {
        button.text = text
        button.setOnClickListener(onClickListener)
    }
}