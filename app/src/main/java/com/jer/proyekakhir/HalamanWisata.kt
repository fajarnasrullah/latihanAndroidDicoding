package com.jer.proyekakhir

import android.app.Person
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class HalamanWisata : AppCompatActivity() {

//    companion object {
//        const val EXTRA_NAME = "extra_name"
//        const val EXTRA_PHOTO = "extra_photo"
//        const val EXTRA_DESCRIPTION = "extra_description"
//    }

//    private val list = ArrayList<DestinasiWisata>()
//    private lateinit var rv_halaman_wisata : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_wisata)

//        rv_halaman_wisata = findViewById(R.id.rv_halaman_wisata)
//        rv_halaman_wisata.setHasFixedSize(true)
//
//        list.addAll(getListDestination())
//        showRecyclerList()



        val tvDetailName : TextView = findViewById(R.id.judulDesti)
        val ivDetailPhoto : ImageView = findViewById(R.id.imageDesti)
        val tvDetailDescription : TextView= findViewById(R.id.deskripsiDesti)
        val tvDetailLocation : TextView = findViewById(R.id.lokasiDesti)
        val tvDetailTinggi : TextView = findViewById(R.id.tinggiLuasDesti)

        val namaHalaman = intent.getStringExtra("mName")
        val photoHalaman = intent.getStringExtra("mPhoto")
        val deskripsiHalaman = intent.getStringExtra("mDetail")
        val lokasiHalaman = intent.getStringExtra("mLokasi")
        val tinggiHalaman = intent.getStringExtra("mTinggi")

        tvDetailName.text = namaHalaman
        tvDetailDescription.text = deskripsiHalaman
        tvDetailLocation.text = lokasiHalaman
        tvDetailTinggi.text = tinggiHalaman
//        if (photoHalaman != null) {
//            ivDetailPhoto.setImageResource(photoHalaman)
//        }

        Glide.with(this)
            .load(photoHalaman)
            .apply(RequestOptions().override(300,300))
            .into(ivDetailPhoto)
//        Glide.with(this)
//            .load(photoHalaman)
//            .into(ivDetailPhoto)

//        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
//            intent.getParcelableExtra<Person>(key_hero, DestinasiWisata::class.java)
//        } else {
//            @Suppress("DEPRECATION")
//            intent.getParcelableExtra<Person>(key_hero)
//        }

//        tvDetailName.text = namaHalaman
//        if (photoHalaman != null) {
//            ivDetailPhoto.setImageResource(photoHalaman)
//        }
//        tvDetailDescription.text = deskripsiHalaman
//
//        val dataDesti = if (Build.VERSION.SDK_INT >= 33) {
//
//            intent.getParcelableExtra<DestinasiWisata>(EXTRA_NAME, DestinasiWisata::class.java)
//            intent.getParcelableExtra<DestinasiWisata>(EXTRA_PHOTO, DestinasiWisata::class.java)
//            intent.getParcelableExtra<DestinasiWisata>(EXTRA_DESCRIPTION, DestinasiWisata::class.java)
//        } else {
//
//            @Suppress("DEPRECATION")
//            intent.getParcelableExtra<DestinasiWisata>(EXTRA_NAME)
//            intent.getParcelableExtra<DestinasiWisata>(EXTRA_PHOTO)
//            intent.getParcelableExtra<DestinasiWisata>(EXTRA_DESCRIPTION)
//        }
////
////
////
////
////
//        if (dataDesti != null) {
//            tvDetailName.text = dataDesti.nama_destinasi
//        }
//        if (dataDesti != null) {
//            tvDetailDescription.text = dataDesti.deskripsi_destinasi
//        }
//        if (dataDesti != null) {
//            ivDetailPhoto.setImageResource(dataDesti.gambar_destinasi)
//        }
    }


//    private fun showRecyclerList() {
//        rv_halaman_wisata.layoutManager = LinearLayoutManager(this)
//
//        val halamanWisataAdapter = adapterHalamanWisata(list)
//
//        rv_halaman_wisata.adapter = halamanWisataAdapter



//        halamanWisataAdapter.setOnItemClickCallback2(object : adapterHalamanWisata.OnItemClickCallback2 {
//            override fun onItemClicked(data: DestinasiWisata) {
//                showSelectedDestination(data)
//            }
//        })
//    }

//    private fun getListDestination(): ArrayList<DestinasiWisata> {
//        val dataName2 = resources.getStringArray(R.array.data_name)
//        val dataDescription2 = resources.getStringArray(R.array.data_description)
//        val dataPhoto2 = resources.getStringArray(R.array.data_photo)
//        val listDestination2 = ArrayList<DestinasiWisata>()
//        for (i in dataName2.indices) {
//            val destinasi = DestinasiWisata(dataName2[i], dataDescription2[i], dataPhoto2[i])
//            listDestination2.add(destinasi)
//        }
//        return listDestination2
//    }
}

fun ImageView.setImageResource(photoHalaman: String) {

}

//fun ImageView.setImageResource(photoHalaman: String) {
//
//}

//private fun ImageView.setImageResource(gambarDestinasi: String) {
//    
//}
