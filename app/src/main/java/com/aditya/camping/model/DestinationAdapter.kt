package com.aditya.camping.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aditya.camping.R
import com.bumptech.glide.Glide
import java.util.ArrayList

class DestinationAdapter(private val listDestination: ArrayList<ModelPlace>): RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>() {
    private lateinit var onItemClickedCallback: OnItemClickCallBack

    inner class DestinationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_description)
        var btnDetail: Button = itemView.findViewById(R.id.btn_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_destination)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallBack){
        this.onItemClickedCallback = onItemClickedCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_destination, parent, false)
        return DestinationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDestination.size
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val destination = listDestination[position]
        Glide.with(holder.itemView.context)
                .load(destination.photo).into(holder.imgPhoto)
        holder.tvName.text = destination.name
        holder.tvDescription.text = destination.description
        holder.itemView.setOnClickListener{
            onItemClickedCallback.onItemClicked(listDestination[holder.adapterPosition])
        }
        holder.btnDetail.setOnClickListener {
            onItemClickedCallback.onItemClicked(listDestination[holder.adapterPosition])
        }
    }

    interface OnItemClickCallBack{
        fun onItemClicked(data: ModelPlace)
    }
}