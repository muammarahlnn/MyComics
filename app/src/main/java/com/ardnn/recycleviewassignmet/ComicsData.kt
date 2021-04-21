package com.ardnn.recycleviewassignmet

import android.app.Activity

object ComicsData {
    private var dataset = arrayListOf<ArrayList<String>>()
    private val comicPhotos = arrayOf(
            intArrayOf(R.drawable.op_cover, R.drawable.op_wallpaper),
            intArrayOf(R.drawable.hxh_cover, R.drawable.hxh_wallpaper),
            intArrayOf(R.drawable.naruto_cover, R.drawable.naruto_wallpaper),
            intArrayOf(R.drawable.hitman_cover, R.drawable.hitman_wallpaper),
            intArrayOf(R.drawable.haikyuu_cover, R.drawable.haikyuu_wallpaper),
            intArrayOf(R.drawable.bnha_cover, R.drawable.bnha_wallpaper),
            intArrayOf(R.drawable.opm_cover, R.drawable.opm_wallpaper),
            intArrayOf(R.drawable.solo_cover, R.drawable.solo_wallpaper),
            intArrayOf(R.drawable.kny_cover, R.drawable.kny_wallpaper),
            intArrayOf(R.drawable.snk_cover, R.drawable.snk_wallpaper),
            intArrayOf(R.drawable.kuroko_cover, R.drawable.kuroko_wallpaper)
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
                comic.image = comicPhotos[i][0]
                comic.wallpaper = comicPhotos[i][1]

                list.add(comic)
            }

            return list
        }

}