package com.example.sejutamanfaatrempahindonesia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sejutamanfaatrempahindonesia.data.Jenis
import com.example.sejutamanfaatrempahindonesia.data.User
import com.example.sejutamanfaatrempahindonesia.ui.adapter.UserAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvJenis: RecyclerView
    private var list: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvJenis = findViewById(R.id.listUser)
        rvJenis.setHasFixedSize(true)

        list.addAll(Jenis.listUser)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvJenis.layoutManager = LinearLayoutManager(this)
        val UserAdapter = UserAdapter(list)
        rvJenis.adapter = UserAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedModel: Int) {
        when(selectedModel) {
            R.id.action_profile -> {
                val profile = Intent(this@MainActivity,
                    ProfileActivity::class.java)
                startActivity(profile)
            }
        }
    }


}
