package com.sberbank.recyclerviewtemplate.view.trickyrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.sberbank.recyclerviewtemplate.R
import com.sberbank.recyclerviewtemplate.view.trickyrecycler.viewholders.StandartButtonViewHolder
import com.sberbank.recyclerviewtemplate.view.trickyrecycler.viewholders.StandartTextViewViewHolder

class TrickyRecyclerViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = listOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)

        return when (ViewType.getViewTypeByInt(viewType)) {
            ViewType.STANDART_TEXT_VIEW -> StandartTextViewViewHolder(view)
            ViewType.STANDART_BUTTON -> StandartButtonViewHolder(view)
            // Add or change some elements (Create viewholder TOO)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is Item.StandartTextView ->
                (holder as StandartTextViewViewHolder).bind(item.text)
            is Item.StandartButton ->
                (holder as StandartButtonViewHolder).bind(item.text, item.onClickListener)
            // Add or change some elements
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int = items[position].viewType.layoutRes

    fun setContent() {
        items = mutableListOf<Item>().apply {
            add(Item.StandartButton("SOME BUTTON") {
            })
            add(Item.StandartTextView("HELLO WORLD"))
            add(Item.StandartTextView("HELLO WORLD"))
            add(Item.StandartTextView("HELLO WORLD"))
            add(Item.StandartTextView("HELLO WORLD"))
            add(Item.StandartTextView("HELLO WORLD"))
            add(Item.StandartButton("BUTT'ON1") {
            })
            add(Item.StandartButton("BUTT'ON2222") {
            })
        }
    }

    enum class ViewType(@LayoutRes val layoutRes: Int) {
        STANDART_TEXT_VIEW(R.layout.some_textview_item),
        STANDART_BUTTON(R.layout.some_button_item);
        // Add or change some elements

        companion object {
            fun getViewTypeByInt(viewType: Int) = when (viewType) {
                STANDART_TEXT_VIEW.layoutRes -> STANDART_TEXT_VIEW
                STANDART_BUTTON.layoutRes -> STANDART_BUTTON
                // Add or change some elements
                else -> throw IllegalStateException("Unknown layout")
            }
        }
    }

    private sealed class Item(val viewType: ViewType) {

        class StandartTextView(val text: String) : Item(ViewType.STANDART_TEXT_VIEW)

        class StandartButton(val text: String, val onClickListener: View.OnClickListener) :
            Item(ViewType.STANDART_BUTTON)

        // Add or change some elements
    }
}
