package com.jer.proyekakhir

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class adapternyaListDestinasi (private val listDestinasi: ArrayList<DestinasiWisata>, val context: Context) : RecyclerView.Adapter<adapternyaListDestinasi.ListViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(iniDesti:DestinasiWisata) {
            val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_list)
            val tvName: TextView = itemView.findViewById(R.id.tv_item_nameDesti)
            val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

//            val imgPhoto2: ImageView = itemView.findViewById((R.id.imageDesti))
//            val tvName2: TextView = itemView.findViewById((R.id.judulDesti))
//            val tvDescription2: TextView = itemView.findViewById((R.id.deskripsiDesti))

            val imgUrl = iniDesti.gambar_destinasi

            tvName.text = iniDesti.nama_destinasi
            tvDescription.text = iniDesti.deskripsi_destinasi
            imgPhoto.setImageResource(iniDesti.gambar_destinasi)

            Glide.with(itemView.context)
                .load(imgUrl)
                .apply(RequestOptions().override(300,300))
                .into(imgPhoto)
//            tvName2.text = iniDesti.nama_destinasi
//            tvDescription2.text = iniDesti.deskripsi_destinasi
//            imgPhoto2.setImageResource(iniDesti.gambar_destinasi)
        }
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
        holder.bindItem(listDestinasi[position])


//        Glide.with(this)
//            .load(imgPhoto)
//            .apply(RequestOptions().override(300,300))
//            .into(ivDetailPhoto)

//        val iniDesti = listDestinasi[position]
//        Glide.with(holder.itemView.context)
//            .load(iniDesti.imgPhoto)
////            .apply(RequestOptions().override(55, 55))
//            .into(holder.photo)
//        holder.tvName.text = iniDesti.tvName
//        holder.tvDetail.text = iniDesti.tvDetail
//        val (name, description, photo) = listDestinasi[position]
//        Glide.with(holder.itemView.context)
//            .load(photo) // URL Gambar
//            .into(holder.imgPhoto)
//        holder.tvName.text = name
//        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            val getData = listDestinasi.get(position)
            val DetailName: String = getData.nama_destinasi
            val DetailDesc: String = getData.deskripsi_destinasi
            val DetailPhoto: String = getData.gambar_destinasi
            val DetailLokasi: String = getData.lokasi_destinasi
            val DetailTinggi: String = getData.tinggi_luas_destinasi


            onItemClickCallback.onItemClicked(listDestinasi[holder.adapterPosition])
            val intentDetail = Intent(holder.itemView.context, HalamanWisata::class.java)
            intentDetail.putExtra("key_hero", listDestinasi[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)

            val moveToDetail = Intent(context, HalamanWisata::class.java)
            moveToDetail.putExtra("mName", DetailName)
            moveToDetail.putExtra("mDetail", DetailDesc)
            moveToDetail.putExtra("mPhoto", DetailPhoto)
            moveToDetail.putExtra("mLokasi", DetailLokasi)
            moveToDetail.putExtra("mTinggi", DetailTinggi)

//            val moveTopageabout = Intent(context, page_about::class.java)
//            moveTopageabout.putExtra("saya",DetailName)
//            moveTopageabout.putExtra("email_saya",DetailDesc)
//            moveTopageabout.putExtra("foto_saya",DetailPhoto)
//            context.startActivity(moveTopageabout)
            context.startActivity(moveToDetail)
        }



    }

    override fun getItemCount(): Int = listDestinasi.size

    interface OnItemClickCallback {
        fun onItemClicked(data: DestinasiWisata)
    }

}