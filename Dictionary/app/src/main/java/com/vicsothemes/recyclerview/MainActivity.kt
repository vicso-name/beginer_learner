package com.vicsothemes.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vicsothemes.recyclerview.adapters.ChapterListAdapter

class MainActivity : AppCompatActivity() {

    private var layoutManager:RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ChapterListAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chapterList = findViewById<RecyclerView>(R.id.chapterList)

        layoutManager = LinearLayoutManager(this)
        chapterList.layoutManager = layoutManager

        chapterList.adapter = ChapterListAdapter{ position ->

            val lettersActivity = Intent(this, LettersActivity::class.java)

            when (position) {
                1 -> startActivity(lettersActivity)
            }
        }
    }
}