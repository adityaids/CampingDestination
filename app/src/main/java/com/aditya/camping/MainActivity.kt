package com.aditya.camping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.aditya.camping.model.DataPlace
import com.aditya.camping.model.ModelPlace
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var listDestination: ArrayList<ModelPlace>
    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rv_main)
        rvMain.setHasFixedSize(true)

        listDestination.addAll(DataPlace.listData)

    }
}