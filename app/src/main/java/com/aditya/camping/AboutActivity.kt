package com.aditya.camping

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AboutActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIg: Button
    private lateinit var btnLinkedIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = "About"

        btnIg = findViewById(R.id.btn_instagram)
        btnLinkedIn = findViewById(R.id.btn_linkedin)

        btnIg.setOnClickListener(this)
        btnLinkedIn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_instagram -> {
                val igUri = "https://www.instagram.com/adityaids/"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(igUri)
                startActivity(intent)
            }
            R.id.btn_linkedin -> {
                val linkedinUri = "https://www.linkedin.com/in/aditya-purnama-8657691a4/"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(linkedinUri)
                startActivity(intent)
            }
        }
    }
}