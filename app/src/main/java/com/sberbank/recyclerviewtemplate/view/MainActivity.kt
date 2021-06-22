package com.sberbank.recyclerviewtemplate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.sberbank.recyclerviewtemplate.R
import com.sberbank.recyclerviewtemplate.view.trickyrecycler.TrickyRecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var someRecyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
        initRecycler()
    }

    private fun findViews(){
        someRecyclerView=findViewById(R.id.some_recyclerview)
    }

    private fun initRecycler(){
        val recyclerViewAdapter= TrickyRecyclerViewAdapter()
        someRecyclerView.adapter=recyclerViewAdapter
        recyclerViewAdapter.setContent()
        recyclerViewAdapter.notifyDataSetChanged()
    }

}