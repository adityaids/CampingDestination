package com.aditya.camping

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aditya.camping.model.DataPlace
import com.aditya.camping.model.DestinationAdapter
import com.aditya.camping.model.ModelPlace
import java.util.*

class MainActivity : AppCompatActivity() {

    private var listDestination: ArrayList<ModelPlace> = arrayListOf()
    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rv_main)
        rvMain.setHasFixedSize(true)

        listDestination.addAll(DataPlace.listData)
        showRecyclerView()
    }

    private fun showRecyclerView(){
        rvMain.layoutManager = LinearLayoutManager(this)
        val listDestinationAdapter = DestinationAdapter(listDestination)
        rvMain.adapter = listDestinationAdapter
        listDestinationAdapter.setOnItemClickCallback(object: DestinationAdapter.OnItemClickCallBack{
            override fun onItemClicked(data: ModelPlace, imageView: View, title: View) {
                val imagePair = Pair.create(imageView, DetailActivity.EXTRA_IMAGE_TRANSITION)
                val titlePair = Pair.create(title, DetailActivity.EXTRA_TITLE_TRANSITION)

                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_DESTINATION, data)
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val activityOption = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity, imagePair, titlePair)
                    startActivity(intent, activityOption.toBundle())
                } else {
                    startActivity(intent)
                }
            }
        })
    }
}