package com.naufal.jepang

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.naufal.jepang.adapter.AdapterGambar


class halaman2 : AppCompatActivity() {


    private val imageList = arrayOf(
        R.drawable.bkg,
        R.drawable.td,
        R.drawable.gf,
        R.drawable.oc
    )

    private val judul = arrayOf("Sensō-ji", "Tokyo Disney", "Mount Fuji", "Osaka Castle")
    private val lokasi = arrayOf("Lokasi :  Tokyo", "Lokasi : Urayasu", "Lokasi : Fujinomiya", "Lokasi : Osaka ");
    private val tgl = arrayOf(
        "Tanggal : 15-April-1983",
        "Tanggal : Tahun 1707",
        "Tanggal : Tahun 645 M",
        "Tanggal : 1583"
    )

    private val des = arrayOf(
        "The oldest Buddhist temple in Tokyo, located in Asakusa. Famous for its Kaminarimon gate and serves as a spiritual and cultural center of Japan.",
        "A major theme park in Tokyo consisting of two main parks, Tokyo Disneyland and Tokyo DisneySea. It was the first Disney park to open outside the United States.",
        "The highest mountain in Japan, standing at 3,776 meters. Mount Fuji is one of Japan's most iconic symbols and is a popular destination for hiking and sightseeing.",
        "One of Japan’s most famous castles, originally built in 1583 by Toyotomi Hideyoshi. It played a crucial role during Japan’s feudal era and now serves as a historical and cultural museum."
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_halaman2)


        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter = AdapterGambar(this, imageList, judul, lokasi)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, detail_gambar::class.java)
            intent.putExtra("Gambar", imageList[position])
            intent.putExtra("Judul", judul[position])
            intent.putExtra("Lokasi", lokasi[position])
            intent.putExtra("tanggal", tgl[position])
            intent.putExtra("Deskripsi", des[position])
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gridView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}