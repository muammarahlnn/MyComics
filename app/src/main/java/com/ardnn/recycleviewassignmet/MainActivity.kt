package com.ardnn.recycleviewassignmet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvComics: RecyclerView
    private var listComics: ArrayList<Comic> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvComics = findViewById(R.id.rv_comics)
        rvComics.setHasFixedSize(true)

        listComics.addAll(ComicsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvComics.layoutManager = LinearLayoutManager(this)
        val comicsAdapter = ComicsAdapter(listComics)
        rvComics.adapter = comicsAdapter
    }


}