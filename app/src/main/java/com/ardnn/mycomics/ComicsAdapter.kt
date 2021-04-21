package com.ardnn.mycomics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComicsAdapter(private val listComics: ArrayList<Comic>)
    : RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

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

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listComics[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listComics.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvComicsTitle: TextView = itemView.findViewById(R.id.tv_comics_title)
        var tvComicsSummary: TextView = itemView.findViewById(R.id.tv_comics_summary)
        var ivComicsImage: ImageView = itemView.findViewById(R.id.iv_comics_image)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Comic)
    }

}