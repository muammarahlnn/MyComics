package com.ardnn.mycomics

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment() : Fragment(), OnItemClickListener<Comic> {

    private lateinit var rvComics: RecyclerView
    private lateinit var comicsAdapter: ComicsAdapter

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString(MainActivity.EXTRA_STRING, "MyComics")
            fragment.arguments = args

            return fragment
        }

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialization
        rvComics  = view.findViewById(R.id.rv_comics_home)
        comicsAdapter = ComicsAdapter()
    }

    override fun onStart() {
        super.onStart()

        comicsAdapter.setClickListener(this)
        comicsAdapter.setComics(ComicsData.listData)

        rvComics.layoutManager = LinearLayoutManager(activity)
        rvComics.setHasFixedSize(true)
        rvComics.adapter = comicsAdapter
    }

    override fun onClick(comic: Comic) {
        // add comic to recent comics
        ComicsData.addRecentComic(comic)

        // go to detail activity
        val goToDetail = Intent(activity, DetailActivity::class.java)
        goToDetail.putExtra(DetailActivity.EXTRA_COMICS, comic)
        startActivity(goToDetail)
    }

}