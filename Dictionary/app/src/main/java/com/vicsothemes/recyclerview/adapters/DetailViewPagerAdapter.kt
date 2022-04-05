package com.vicsothemes.recyclerview.adapters

import Letters
import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.vicsothemes.recyclerview.DetailActivity
import com.vicsothemes.recyclerview.R

class DetailViewPagerAdapter(
    private val lettersList: List<Letters>,
    private val activity: DetailActivity,
    viewPager2: ViewPager2
) : RecyclerView.Adapter<DetailViewPagerAdapter.DetailViewHolder>() {

    class DetailViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val toolbar: Toolbar = itemView.findViewById(R.id.detail_toolbar)
        private val banner: ImageView = itemView.findViewById(R.id.detail_image_view)
        private val title: TextView = itemView.findViewById(R.id.title_detail_text_view)
        private val sample_detail: TextView = itemView.findViewById(R.id.sample_detail)
        private val description: TextView = itemView.findViewById(R.id.letter_description)
        private val playButton: ImageButton = itemView.findViewById(R.id.playButton)


        fun bind(
            leter: Letters
        ) {
            banner.setImageResource(leter.banner)
            title.text = leter.title
            sample_detail.text = leter.sample
            description.text = leter.description
            toolbar.title = leter.title
            playButton.setOnClickListener{
                var mp = MediaPlayer()
                mp.setAudioStreamType(leter.sound)
                mp.prepare()
                mp.start()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_detail_adapter, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val letersArgs: Letters = lettersList[position]
        holder.bind(letersArgs)
        
        holder.toolbar.setNavigationOnClickListener {
            activity.finish()
        }
    }

    override fun getItemCount() = lettersList.size
}