package com.vicsothemes.recyclerview.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.vicsothemes.recyclerview.R

class ChapterListAdapter(private val listener: (position: Int) -> Unit):
    RecyclerView.Adapter<ChapterListAdapter.ViewHolder>() {

    companion object{
        private const val TAG = "ChapterListAdapter"
    }

    private var chapter_titles = arrayOf(
        "Helpful Tips",
        "English Alphabet",
        "Super Quiz",
        "Learn Game",
        "Words Set"
    )
    private var chapter_descrs = arrayOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chapter_titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.chapter_item.text = chapter_titles[position]
        holder.chapter_details.text = chapter_descrs[position]
        when(position){
            0 -> {
                holder.chapter_card.setCardBackgroundColor(Color.parseColor("#ff5668"))
            }
            1 -> {
                holder.chapter_card.setCardBackgroundColor(Color.parseColor("#41d5e2"))
            }
            2 -> {
                holder.chapter_card.setCardBackgroundColor(Color.parseColor("#4d53e0"))
            }
            3 -> {
                holder.chapter_card.setCardBackgroundColor(Color.parseColor("#ff8e36"))
            }
            4 -> {
                holder.chapter_card.setCardBackgroundColor(Color.parseColor("#8CED8C"))
            }
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        lateinit var chapter_image: ImageView
        lateinit var chapter_item: TextView
        lateinit var chapter_details: TextView
        lateinit var chapter_card: CardView

        init {
            itemView.setOnClickListener(this)
            chapter_image = itemView.findViewById(R.id.chapter_image)
            chapter_item = itemView.findViewById(R.id.chapter_title)
            chapter_details = itemView.findViewById(R.id.chapter_details)
            chapter_card = itemView.findViewById(R.id.chapter_card)
        }

        override fun onClick(v: View?) {
            listener.invoke(adapterPosition)
        }
    }
}
