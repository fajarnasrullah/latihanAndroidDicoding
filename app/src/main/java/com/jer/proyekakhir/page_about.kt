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

        val namaku2= intent.getStringExtra("saya")
        val emailku2 = intent.getStringExtra("email_saya")
        val fotoku2 = intent.getStringExtra("foto_saya")

        namaku.text = namaku2
        emailku.text = emailku2
        if (fotoku2 != null) {
            fotoku.setImageResource(fotoku2)
        }
    }
}