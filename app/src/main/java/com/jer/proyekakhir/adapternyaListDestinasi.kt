package com.jer.proyekakhir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class adapternyaListDestinasi (private val listDestinasi: ArrayList<DestinasiWisata>) : RecyclerView.Adapter<adapternyaListDestinasi.ListViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_list)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_nameDesti)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
//        val imgHalaman: ImageView = itemView.findViewById(R.id.imageDesti)
//        val judulHalaman: TextView = itemView.findViewById(R.id.judulDesti)
//        val deskripsiHalaman: TextView = itemView.findViewById(R.id.deskripsiDesti)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.deret_item_destinasi, parent, false)
//        val view3: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_halaman_wisata, parent, false)
        return ListViewHolder(view)
//        return ListViewHolder(view3)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listDestinasi[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listDestinasi[holder.adapterPosition])
            val intentDetail = Intent(holder.itemView.context, HalamanWisata::class.java)
            intentDetail.putExtra("key_hero", listDestinasi[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }

//        val (name2, description2, photo2) = listDestinasi[position]
//        Glide.with(holder.itemView.context)
//            .load(photo2) // URL Gambar
//            .into(holder.imgHalaman)
//        holder.judulHalaman.text = name2
//        holder.deskripsiHalaman.text = description2
//        holder.itemView.setOnClickListener {
//            onItemClickCallback.onItemClicked(listDestinasi[holder.adapterPosition])
//            val intentDetail2 = Intent(holder.itemView.context, HalamanWisata::class.java)
//            intentDetail2.putExtra("key_hero", listDestinasi[holder.adapterPosition])
//            holder.itemView.context.startActivity(intentDetail2)
//        }
    }

    override fun getItemCount(): Int = listDestinasi.size

    interface OnItemClickCallback {
        fun onItemClicked(data: DestinasiWisata)
    }

}