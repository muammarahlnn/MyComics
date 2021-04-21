package com.ardnn.recycleviewassignmet

import android.app.Activity
import android.util.Log

object ComicsData {
    private var dataset = arrayListOf<ArrayList<String>>()
    private val comicImages = intArrayOf(
            R.drawable.onepiece,
            R.drawable.hxh,
            R.drawable.naruto,
            R.drawable.hitman,
            R.drawable.haikyuu,
            R.drawable.bnha,
            R.drawable.opm,
            R.drawable.solo,
            R.drawable.kny,
            R.drawable.snk,
            R.drawable.kuroko
    )

    fun getDataset(context: Activity, filename: String) {
        val text = context.assets.open(filename).bufferedReader().use {
            it.readText()
        }
        val comics = text.split("\n").toList()
        for (i in comics.indices) {
            val data = comics[i].split(";").toList()
            dataset.add(data as ArrayList<String>)
        }

        // debug
//        var temp = ""
//        for (i in dataset.indices) {
//            for (j in dataset[i].indices) {
//                temp += "${dataset[i][j]}\n"
//            }
//            temp += "\n"
//        }
//
//        Log.d("ComicsData", temp)
    }


    val listData: ArrayList<Comic>
        get() {
            val list = arrayListOf<Comic>()
            for (i in dataset.indices) {
                val comic = Comic()
                comic.title = dataset[i][0]
                comic.author = dataset[i][1]
                comic.publisher = dataset[i][2]
                comic.summary = dataset[i][3]
                comic.synopsis = dataset[i][4]
                comic.image = comicImages[i]

                list.add(comic)
            }

            return list
        }

}