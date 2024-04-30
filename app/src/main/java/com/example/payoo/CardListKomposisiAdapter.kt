package com.example.payoo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CardListKomposisiAdapter(private var komposisiList: List<KomposisiItem>) : RecyclerView.Adapter<CardListKomposisiAdapter.KomposisiViewHolder>() {

    inner class KomposisiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUrutan: TextView = itemView.findViewById(R.id.tv_urutan)
        val tvNamaProduk: TextView = itemView.findViewById(R.id.tv_nama_komposisi)
        val tvHargaAsli: TextView = itemView.findViewById(R.id.tv_harga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KomposisiViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_list_komposisi, parent, false)
        return KomposisiViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: KomposisiViewHolder, position: Int) {
        val komposisi = komposisiList[position]
        holder.tvUrutan.text = (position + 1).toString()
        holder.tvNamaProduk.text = komposisi.namaKomposisi
        holder.tvHargaAsli.text=komposisi.harga.toString()
    }
    override fun getItemCount(): Int {
        return komposisiList.size
    }
    fun updateData(newKomposisiList: List<KomposisiItem>) {
        komposisiList = newKomposisiList
        notifyDataSetChanged()
    }
}
