package com.aditya.camping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            override fun onItemClicked(data: ModelPlace) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_DESTINATION, data)
                }
                startActivity(intent)
            }
        })
    }
}