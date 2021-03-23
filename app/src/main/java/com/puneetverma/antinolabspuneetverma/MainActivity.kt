package com.puneetverma.antinolabspuneetverma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puneetverma.antinolabspuneetverma.rest.models.articles
import com.puneetverma.antinolabspuneetverma.rest.repository.Repository
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    var adaptor: NewsRvAdaptor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val rv= this.findViewById<RecyclerView>(R.id.rv_news)

        var news_list = ArrayList<News>()


        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)

        viewModel.getNews()

        viewModel.MyResponse.observe(this, Observer { response ->

            var article_list = ArrayList<articles>()
            article_list=response.articles



            //news_list[0].heading = article_list[0].title


            for(obj in article_list)
            {
                Log.d("newsList", "onCreate: " + obj.url)
                var news = News(obj.title,obj.description,obj.urlToImage,obj.url)
                news_list.add(news)

            }

            adaptor?.notifyDataSetChanged()

        })



        adaptor  = NewsRvAdaptor(news_list,this)
        rv.adapter = adaptor
        rv.layoutManager = LinearLayoutManager(this)



    }
}