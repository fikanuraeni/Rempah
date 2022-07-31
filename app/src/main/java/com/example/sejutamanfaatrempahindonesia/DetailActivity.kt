package com.example.sejutamanfaatrempahindonesia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    companion object {
        const val NAME = "detailName"
        const val DESC = "detailDescription"
        const val DETAIL = "detailDetail"
        const val ID = "detailId"
        const val IMG = "detailImg"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.detailName)
        val tvDesc: TextView = findViewById(R.id.detailDesc)
        val tvDetail: TextView = findViewById(R.id.detailDetail)
        val tvId: TextView = findViewById(R.id.detailId)
        val tvImg: ImageView = findViewById(R.id.detailImg)

        val dName = intent.getStringExtra(NAME)
        val dDesc = intent.getStringExtra(DESC)
        val dDetail = intent.getStringExtra(DETAIL)
        val dId = intent.getIntExtra(ID, 0)
        val dImg = intent.getIntExtra(IMG, 0)

        tvName.text = dName
        tvDetail.text = dDetail
        tvDesc.text = dDesc
        tvId.text = dId.toString()

        Glide.with(this)
            .load(dImg)
            .apply(RequestOptions())
            .into(tvImg)
    }
}