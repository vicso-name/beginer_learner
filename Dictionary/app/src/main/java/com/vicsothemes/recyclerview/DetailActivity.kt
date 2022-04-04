package com.vicsothemes.recyclerview

import Letters
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.vicsothemes.recyclerview.adapters.DetailViewPagerAdapter

class DetailActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val leters: Letters = intent.getParcelableExtra("Intent to Detail Activity")!!
        val lettersList: List<Letters> = Letters.lettersList(applicationContext)

        viewPager2 = findViewById(R.id.detail_view_pager)
        viewPager2.setPageTransformer(ZoomOutPageTransformer())

        val viewPagerAdapter = DetailViewPagerAdapter(lettersList, this, viewPager2)
        viewPager2.adapter = viewPagerAdapter
        viewPager2.setCurrentItem(leters.id, false)
    }
}