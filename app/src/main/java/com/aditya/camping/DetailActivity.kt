package com.aditya.camping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.aditya.camping.model.ModelPlace
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity(), View.OnClickListener{

    companion object{
        const val EXTRA_DESTINATION: String = "extra_destination"
    }
    lateinit var tvDetailName: TextView
    lateinit var tvDetailDescription: TextView
    lateinit var imgDetail: ImageView
    lateinit var btnFavorit: Button
    lateinit var btnShare: Button
    private lateinit var destination: ModelPlace

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvDetailName = findViewById(R.id.tv_name_detail)
        tvDetailDescription = findViewById(R.id.tv_description_detail)
        imgDetail = findViewById(R.id.img_detail)
        btnFavorit = findViewById(R.id.btn_favorit_detail)
        btnShare = findViewById(R.id.btn_share_detail)

        destination = intent.getSerializableExtra(EXTRA_DESTINATION) as ModelPlace
        Glide.with(this)
                .load(destination.photo)
                .into(imgDetail)

        tvDetailName.text = destination.name
        tvDetailDescription.text = destination.description

        if (destination.isFavorited) {
            val drawable = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
            btnFavorit.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
        }

        btnFavorit.setOnClickListener(this)
        btnShare.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_favorit_detail) {
            val drawable = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
            btnFavorit.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
            Toast.makeText(this, "Added To Favorit", Toast.LENGTH_LONG).show()
        } else {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TITLE, destination.name)
                putExtra(Intent.EXTRA_TEXT, destination.description)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Share")
            startActivity(shareIntent)
        }
    }
}