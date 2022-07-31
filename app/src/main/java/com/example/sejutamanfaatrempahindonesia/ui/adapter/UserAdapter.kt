package com.example.sejutamanfaatrempahindonesia.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sejutamanfaatrempahindonesia.DetailActivity
import com.example.sejutamanfaatrempahindonesia.R
import com.example.sejutamanfaatrempahindonesia.data.User

class UserAdapter (private val listJenis: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ListViewHolder(view)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val jenis = listJenis [position]

        Glide.with(holder.itemView.context)
            .load(jenis.img)
            .apply(RequestOptions().override(55, 55))
            .into((holder.tvImg))

        holder.tvName.text = jenis.name
        holder.tvDesc.text = jenis.description

        val moveDetail = holder.itemView.context

        holder.itemView.setOnClickListener{
            val moveToDetail = Intent(moveDetail, DetailActivity::class.java)

            moveToDetail.putExtra(DetailActivity.NAME, jenis.name)
            moveToDetail.putExtra(DetailActivity.DESC, jenis.description)
            moveToDetail.putExtra(DetailActivity.DETAIL, jenis.detail)
            moveToDetail.putExtra(DetailActivity.ID, jenis.id)
            moveToDetail.putExtra(DetailActivity.IMG, jenis.img)
            moveDetail.startActivity(moveToDetail)
        }
    }

    override fun getItemCount(): Int {
        return listJenis.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvDesc: TextView = itemView.findViewById(R.id.tv_description)
        var tvImg: ImageView = itemView.findViewById(R.id.iv_img)

    }
}