package com.jer.proyekakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<DestinasiWisata>()
    private lateinit var rv_destination: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_destination = findViewById(R.id.rv_destination)
        rv_destination.setHasFixedSize(true)

        list.addAll(getListDestination())
        showRecyclerList()
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_about, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.action_list -> {
//                rv_destination.layoutManager = LinearLayoutManager(this)
//            }
//
//        }
//        return super.onOptionsItemSelected(item)
//    }

    private fun showRecyclerList() {
        rv_destination.layoutManager = LinearLayoutManager(this)
        val listDestinasiAdapter = adapternyaListDestinasi(list)
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
        val listDestination = ArrayList<DestinasiWisata>()
        for (i in dataName.indices) {
            val destinasi = DestinasiWisata(dataName[i], dataDescription[i], dataPhoto[i])
            listDestination.add(destinasi)
        }
        return listDestination
    }


    private fun showSelectedDestination(destinasi: DestinasiWisata) {
        Toast.makeText(this, "Pilihan Bagus " + destinasi.nama_destinasi, Toast.LENGTH_SHORT).show()
        val listHeroAdapter = adapternyaListDestinasi(list)
        listHeroAdapter.setOnItemClickCallback(object : adapternyaListDestinasi.OnItemClickCallback {
            override fun onItemClicked(data: DestinasiWisata) {
                showSelectedDestination(data)
            }
        })
    }


}