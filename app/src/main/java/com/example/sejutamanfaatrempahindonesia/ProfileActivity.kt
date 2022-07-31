package com.example.sejutamanfaatrempahindonesia

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val profileImg: ImageView = findViewById(R.id.profileImg)
        val pImg = R.drawable.up

        Glide.with(this)
            .load(pImg)
            .apply(RequestOptions())
            .into(profileImg)
    }
}