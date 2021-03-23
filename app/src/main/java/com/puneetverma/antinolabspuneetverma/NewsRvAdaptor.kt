package com.puneetverma.antinolabspuneetverma

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsRvAdaptor(



    var news_list:ArrayList<News>,
    var context:Context
) : RecyclerView.Adapter<NewsRvAdaptor.NewsHolder>()
{

    inner class NewsHolder(itemView:View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
         val view = LayoutInflater.from(parent.context)
             .inflate(R.layout.item_news_layout,parent,false)

        return NewsHolder(view)
    }

    override fun getItemCount(): Int {
        return news_list.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.tv_news_heading).text= news_list[position].heading
        holder.itemView.findViewById<TextView>(R.id.tv_news_subHeading).text= news_list[position].subHeading

        Glide.with(context).load(news_list[position].urlImage)
            .placeholder(R.drawable.e_bachman)
            .into(holder.itemView.findViewById<ImageView>(R.id.iv_news_image))

        holder.itemView.findViewById<RelativeLayout>(R.id.news_block).setOnClickListener {
            val intent = Intent(context,MyWebView::class.java)
            intent.putExtra("Url",news_list[position].url)
            startActivity(context,intent, null)
        }

    }
}