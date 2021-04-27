package com.ardnn.mycomics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecentComicsAdapter : RecyclerView.Adapter<RecentComicsAdapter.ViewHolder>() {
    private lateinit var listRecentComics: ArrayList<Comic>
    private lateinit var clickListener: OnItemClickListener<Comic>

    fun setComics(listRecentComics: ArrayList<Comic>) {
        this.listRecentComics = listRecentComics
    }

    fun setClickListener(clickListener: OnItemClickListener<Comic>) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_comics_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listRecentComics[position])
    }

    override fun getItemCount(): Int {
        return listRecentComics.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        lateinit var comic: Comic
        var tvComicsTitle: TextView
        var tvComicsSummary: TextView
        var ivComicsImage: ImageView

        init {
            itemView.setOnClickListener(this)
            tvComicsTitle = itemView.findViewById(R.id.tv_comics_title)
            tvComicsSummary = itemView.findViewById(R.id.tv_comics_summary)
            ivComicsImage = itemView.findViewById(R.id.iv_comics_image)
        }

        fun onBind(comic: Comic) {
            this.comic = comic
            tvComicsTitle.text = comic.title
            tvComicsSummary.text = comic.summary
            ivComicsImage.setImageResource(comic.image)
        }

        override fun onClick(v: View?) {
            clickListener.onClick(comic)
        }


    }

}