package com.vicsothemes.recyclerview.adapters

import Letters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vicsothemes.recyclerview.R

class LettersAdapter(
    private val lettersList: List<Letters>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<LettersAdapter.LetersViewHolder>() {

    class LetersViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val banner: ImageView = itemView.findViewById(R.id.icon_image_view)
        private val title: TextView = itemView.findViewById(R.id.title_text_view)

        fun bind(
            leters: Letters,
            onClickListener: OnClickListener
        ) {
            banner.setImageResource(leters.banner)
            title.text = leters.title
            itemView.setOnClickListener {
                onClickListener.onClick(leters)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetersViewHolder {
        return LetersViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.letter_grid_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: LetersViewHolder, position: Int) {
        val leters: Letters = lettersList[position]
        holder.bind(leters, onClickListener)
    }

    override fun getItemCount() = lettersList.size

    class OnClickListener(val clickListener: (leters: Letters) -> Unit) {
        fun onClick(leters: Letters) = clickListener(leters)
    }
}