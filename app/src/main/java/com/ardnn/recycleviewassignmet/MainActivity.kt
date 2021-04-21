package com.ardnn.recycleviewassignmet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvComics: RecyclerView
    private var listComics: ArrayList<Comic> = arrayListOf()
    private val datasetName: String = "dataset.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get dataset comics from assets folder
        ComicsData.getDataset(this, datasetName)


        // initialize widget
        rvComics = findViewById(R.id.rv_comics_main)
        rvComics.setHasFixedSize(true)

        listComics.addAll(ComicsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvComics.layoutManager = LinearLayoutManager(this)
        val comicsAdapter = ComicsAdapter(listComics)
        rvComics.adapter = comicsAdapter

        comicsAdapter.setOnItemClickCallback(object : ComicsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Comic) {
                showSelectedComic(data)
            }
        })
    }

    private fun showSelectedComic(comic: Comic) {
        var goToDetail: Intent = Intent(this@MainActivity, DetailActivity::class.java)
        goToDetail.putExtra(DetailActivity.EXTRAS[0], comic.title)
        goToDetail.putExtra(DetailActivity.EXTRAS[1], comic.author)
        goToDetail.putExtra(DetailActivity.EXTRAS[2], comic.publisher)
        goToDetail.putExtra(DetailActivity.EXTRAS[3], comic.synopsis)
        goToDetail.putExtra(DetailActivity.EXTRAS[4], comic.image)
        goToDetail.putExtra(DetailActivity.EXTRAS[5], comic.wallpaper)
        startActivity(goToDetail)
    }

}