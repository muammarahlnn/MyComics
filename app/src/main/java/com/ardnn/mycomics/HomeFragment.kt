package com.ardnn.mycomics

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var rvComics: RecyclerView
    private var listComics: ArrayList<Comic> = arrayListOf()


    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        rvComics = view.findViewById(R.id.rv_comics_home)
        rvComics.setHasFixedSize(true)

        listComics.addAll(ComicsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvComics.layoutManager = LinearLayoutManager(activity)
        val comicsAdapter = ComicsAdapter(listComics)
        rvComics.adapter = comicsAdapter

        comicsAdapter.setOnItemClickCallback(object : ComicsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Comic) {
                showSelectedItem(data)
            }

        })
    }

    private fun showSelectedItem(comic: Comic) {
        var goToDetail = Intent(activity, DetailActivity::class.java)
        goToDetail.putExtra(DetailActivity.EXTRA_COMICS, comic)
        startActivity(goToDetail)
    }
}