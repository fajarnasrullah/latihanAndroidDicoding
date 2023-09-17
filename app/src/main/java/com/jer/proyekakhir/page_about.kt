package com.jer.proyekakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class page_about : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_about)

        val namaku : TextView = findViewById(R.id.namaKu)
        val fotoku : ImageView = findViewById(R.id.fotoKu)
        val emailku : TextView = findViewById(R.id.emailKu)

        val getStringNamaku= resources.getString(R.string.nama_saya)
        val getStringEmailku = resources.getString(R.string.email_saya)

        namaku.text = getStringNamaku
        emailku.text = getStringEmailku
        fotoku.setImageResource(R.drawable.me)
    }
}