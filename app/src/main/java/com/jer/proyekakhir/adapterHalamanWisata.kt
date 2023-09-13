//package com.jer.proyekakhir
//
//
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//
//
//
//class adapterHalamanWisata (private val listDestinasi2: ArrayList<DestinasiWisata>) : RecyclerView.Adapter<adapterHalamanWisata.ListViewHolder2>(){
//    private lateinit var onItemClickCallback2: OnItemClickCallback2
//
//    fun setOnItemClickCallback2(onItemClickCallback2: OnItemClickCallback2) {
//        this.onItemClickCallback2 = onItemClickCallback2
//    }
//
//    class ListViewHolder2(itemView2: View) : RecyclerView.ViewHolder(itemView2) {
//        val imgPhoto2: ImageView = itemView2.findViewById(R.id.imageDesti)
//        val tvName2: TextView = itemView2.findViewById(R.id.judulDesti)
//        val tvDescription2: TextView = itemView2.findViewById(R.id.deskripsiDesti)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder2 {
//        val view2: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_halaman_wisata, parent, false)
//        return ListViewHolder2(view2)
//    }
//
//    override fun onBindViewHolder(holder: ListViewHolder2, position2: Int) {
//        val (name2, description2, photo2) = listDestinasi2[position2]
//        Glide.with(holder.itemView.context)
//            .load(photo2) // URL Gambar
//            .into(holder.imgPhoto2)
//        holder.tvName2.text = name2
//        holder.tvDescription2.text = description2
//        holder.itemView.setOnClickListener {
//            onItemClickCallback2.onItemClicked(listDestinasi2[holder.adapterPosition])
//            val intentDetail2 = Intent(holder.itemView.context, HalamanWisata::class.java)
//            intentDetail2.putExtra("key_destination", listDestinasi2[holder.adapterPosition])
//            holder.itemView.context.startActivity(intentDetail2)
//
//        }
//
//    }
//
//    override fun getItemCount(): Int = listDestinasi2.size
//
//    interface OnItemClickCallback2 {
//        fun onItemClicked(data: DestinasiWisata)
//    }
//}
//
//
//
//
//
//
