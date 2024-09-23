package com.naufal.jepang.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.naufal.jepang.R


class AdapterGambar (private val context: Context, private val images: Array<Int>,
                     private val nama: Array<String>, private val lokasi: Array<String>
):
    BaseAdapter()
{
    override fun getCount(): Int {
        return images.size
        return nama.size
        return lokasi.size
    }

    override fun getItem(position: Int): Any {
        return images[position]
        return nama[position]
        return lokasi[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val imageView: ImageView
        val jdl : TextView
        val lok : TextView

        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_dest, parent, false)
            imageView = view.findViewById(R.id.gambarWisata)
            jdl = view.findViewById(R.id.txtNama)
            lok = view.findViewById(R.id.txtLokasi)
        } else{
            view = convertView
            imageView = view.findViewById(R.id.gambarWisata)
            jdl = view.findViewById(R.id.txtNama)
            lok = view.findViewById(R.id.txtLokasi)
        }
        imageView.setImageResource(images[position])
        jdl.setText(nama[position])
        lok.setText(lokasi[position])
        return view


    }




}