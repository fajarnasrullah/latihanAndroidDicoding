package com.jer.proyekakhir

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<DestinasiWisata>()
    private lateinit var rv_destination: RecyclerView

//    companion object {
//        var page_about = true
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_destination = findViewById(R.id.rv_destination)
        rv_destination.setHasFixedSize(true)

        list.addAll(getListDestination())
        showRecyclerList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)

//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.main_menu, menu)
//        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                Toast.makeText(this,"about clicked", Toast.LENGTH_SHORT).show()
//                val intent= Intent(this@MainActivity,page_about:: class.java)
//                startActivity(intent)

//                startActivity(Intent(this, page_about::class.java))
                val moveTopageabout2 = Intent(this, page_about::class.java)
                this.startActivity(moveTopageabout2)
//                rv_destination.layoutManager = GridLayoutManager(this, 2)
            }


        }
        return super.onOptionsItemSelected(item)
    }



    private fun showRecyclerList() {
        rv_destination.layoutManager = LinearLayoutManager(this)
        val listDestinasiAdapter = adapternyaListDestinasi(list, this)
//        val halamanWisataAdapter = adapterHalamanWisata(list)
        rv_destination.adapter = listDestinasiAdapter
//        rv_destination.adapter = halamanWisataAdapter

        listDestinasiAdapter.setOnItemClickCallback(object : adapternyaListDestinasi.OnItemClickCallback {
            override fun onItemClicked(data: DestinasiWisata) {
                showSelectedDestination(data)
            }
        })
//        halamanWisataAdapter.setOnItemClickCallback2(object : adapterHalamanWisata.OnItemClickCallback2 {
//            override fun onItemClicked(data: DestinasiWisata) {
//                showSelectedDestination(data)
//            }
//        })
    }

    private fun getListDestination(): ArrayList<DestinasiWisata> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataLokasi = resources.getStringArray(R.array.data_kecamatan)
        val dataTinggi = resources.getStringArray(R.array.data_tinggi_luas)
        val listDestination = ArrayList<DestinasiWisata>()
        for (i in dataName.indices) {
            val destinasi = DestinasiWisata(dataName[i], dataDescription[i], dataPhoto[i], dataLokasi[i], dataTinggi[i])
            listDestination.add(destinasi)
        }
        return listDestination
    }


    private fun showSelectedDestination(destinasi: DestinasiWisata) {
        Toast.makeText(this, "Pilihan Bagus " + destinasi.nama_destinasi, Toast.LENGTH_SHORT).show()
        val listDestinasiAdapter = adapternyaListDestinasi(list, this)
        listDestinasiAdapter.setOnItemClickCallback(object : adapternyaListDestinasi.OnItemClickCallback {
            override fun onItemClicked(data: DestinasiWisata) {
                showSelectedDestination(data)
            }
        })
    }


}