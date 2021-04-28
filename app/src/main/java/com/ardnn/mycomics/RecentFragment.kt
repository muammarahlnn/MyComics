package com.ardnn.mycomics

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecentFragment  : Fragment(), OnItemClickListener<Comic> {

    private lateinit var tvAnnouncement: TextView
    private lateinit var rvRecentComics: RecyclerView
    private lateinit var recentComicsAdapter: RecentComicsAdapter

    companion object {
        fun newInstance(): RecentFragment {
            val fragment = RecentFragment()
            val args = Bundle()
            args.putString(MainActivity.EXTRA_STRING, "Recent")
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?)
    : View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialization
        rvRecentComics = view.findViewById(R.id.rv_comics_recent)
        tvAnnouncement = view.findViewById(R.id.tv_announcement)

        if (!ComicsData.recentComics.isEmpty()) {
            tvAnnouncement.visibility = View.GONE
        }
        recentComicsAdapter = RecentComicsAdapter()
    }

    override fun onStart() {
        super.onStart()


        recentComicsAdapter.setClickListener(this)
        recentComicsAdapter.setComics(ComicsData.recentComics)

        rvRecentComics.layoutManager = LinearLayoutManager(activity)
        rvRecentComics.setHasFixedSize(true)
        rvRecentComics.adapter = recentComicsAdapter

    }

    override fun onClick(comic: Comic) {
        // go to detail activity
        val goToDetail = Intent(activity, DetailActivity::class.java)
        goToDetail.putExtra(DetailActivity.EXTRA_COMICS, comic)
        startActivity(goToDetail)
    }

}