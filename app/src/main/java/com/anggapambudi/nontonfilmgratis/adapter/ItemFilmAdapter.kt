package com.anggapambudi.nontonfilmgratis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anggapambudi.nontonfilmgratis.R
import com.anggapambudi.nontonfilmgratis.response.ResultItem
import com.bumptech.glide.Glide

class ItemFilmAdapter(private val item: ArrayList<ResultItem>):
        RecyclerView.Adapter<ItemFilmAdapter.FilmViewHolder>() {

    class FilmViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(resultItem: ResultItem) {
            val tvPhoto: ImageView = itemView.findViewById(R.id.tvPhoto)
            val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
            val tvRating: TextView = itemView.findViewById(R.id.tvRating)

            Glide.with(tvPhoto).load(resultItem.thumbnail).into(tvPhoto)
            tvTitle.text = "${resultItem.title}\n"
            tvRating.text = resultItem.rating

            if (tvRating.text == "") {
                tvRating.text = "?"
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= FilmViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_recyclerview, parent, false)
    )

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

}