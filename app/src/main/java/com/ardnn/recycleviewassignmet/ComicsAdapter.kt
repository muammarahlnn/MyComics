package com.ardnn.recycleviewassignmet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComicsAdapter(private val listComics: ArrayList<Comic>)
    : RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_comics_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comic = listComics[position]
        holder.tvComicsTitle.text = comic.title
        holder.tvComicsSummary.text = comic.summary
        holder.ivComicsImage.setImageResource(comic.image)
    }

    override fun getItemCount(): Int {
        return listComics.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvComicsTitle: TextView = itemView.findViewById(R.id.tv_comics_title)
        var tvComicsSummary: TextView = itemView.findViewById(R.id.tv_comics_summary)
        var ivComicsImage: ImageView = itemView.findViewById(R.id.iv_comics_image)
    }

}