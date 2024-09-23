package com.naufal.jepang

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detail_gambar : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_gambar)

        val ImagesResId = intent.getIntExtra("Gambar", 0)
        val title = intent.getStringExtra("Judul")
        val lokasi = intent.getStringExtra("Lokasi")
        val tanggal = intent.getStringExtra("tanggal")
        val dec = intent.getStringExtra("Deskripsi")

        val imageView = findViewById<ImageView>(R.id.img)
        val a = findViewById<TextView>(R.id.tvJudl)
        val b = findViewById<TextView>(R.id.tvLokasi)
        val c = findViewById<TextView>(R.id.tvTanggal)
        val d = findViewById<TextView>(R.id.TvDesc)
        imageView.setImageResource(ImagesResId)
        a.setText(title)
        b.setText(lokasi)
        c.setText(tanggal)
        d.setText(dec)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}