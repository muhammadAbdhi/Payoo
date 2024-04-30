package com.example.payoo.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.payoo.R

class CardProdukAdapter(private val dataList: List<CardItem>) : RecyclerView.Adapter<CardProdukAdapter.ViewHolder>() {
    private var favItemList: MutableList<CardItem> = mutableListOf()

    init {
        filterFavItems()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tv_nama_produk)
        val totalTextView: TextView = itemView.findViewById(R.id.tv_harga)
        val jumlahTextView: TextView = itemView.findViewById(R.id.tv_harga_asli)
        val favoriteImageView:ImageView=itemView.findViewById(R.id.favorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_data_produk, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.titleTextView.text = item.title
        holder.totalTextView.text = item.total
        holder.jumlahTextView.text = item.jumlah
        if(item.isfav){
            val favFillDrawable = ContextCompat.getDrawable(holder.itemView.context, R.drawable.fav_fill)
            holder.favoriteImageView.setImageDrawable(favFillDrawable)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
//    fun updateData(newData: List<CardItem>) {
//        dataList.clear()
//        dataList.addAll(newData)
//        filterFavItems()
//        notifyDataSetChanged()
//    }

    private fun filterFavItems() {
        favItemList.clear()
        for (item in dataList) {
            if (item.isfav) {
                favItemList.add(item)
            }
        }
    }
}
