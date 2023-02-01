package com.example.hw3

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3.model.Book

class RecyclerAdapter(private val context: Context, private val dataset: List<Book>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        val item = dataset[position]
        holder.itemTitle.text = context.resources.getString(item.stringTitle)
        holder.itemDetail.text = context.resources.getString(item.stringAuthor)
        holder.itemImage.setImageResource(item.imageResourceId)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener {
                val position: Int = adapterPosition

                val item = dataset[position]
                Toast.makeText(context, "You Clicked on ${context.resources.getString(item.stringTitle)}", Toast.LENGTH_LONG).show()

                val intent = Intent(context, BookInfoActivity::class.java)
                intent.putExtra("book_id", position)
                intent.putExtra("title", context.resources.getString(item.stringTitle))
                intent.putExtra("author", context.resources.getString(item.stringAuthor))
                intent.putExtra("publisher", context.resources.getString(item.stringPublisher))
                intent.putExtra("year", context.resources.getString(item.stringYear))
                intent.putExtra("version", context.resources.getString(item.stringVersion))
                intent.putExtra("summary", context.resources.getString(item.stringSummary))
                intent.putExtra("image", item.imageResourceId)

                context.startActivity(intent)
            }
        }
    }
}