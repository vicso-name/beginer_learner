package com.vicsothemes.recyclerview

import Letters
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.vicsothemes.recyclerview.adapters.LettersAdapter

class LettersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letters)

        val lettersList: List<Letters> = Letters.lettersList(applicationContext)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        val adapter = LettersAdapter(lettersList, leterItemListener)
        recyclerView.adapter = adapter
    }

    private val leterItemListener = LettersAdapter.OnClickListener { leters ->
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("Intent to Detail Activity", leters)
        startActivity(intent)
    }
}