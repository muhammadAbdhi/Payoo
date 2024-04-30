package com.example.payoo.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.payoo.R
import com.example.payoo.databinding.CardDataProdukBinding
import com.example.payoo.entity.Produk

class ProdukAdapter(private val onItemClickCallback: MutableList<Produk>) : RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder>() {

    var listProduk = ArrayList<Produk>()
        set(listNotes) {
            field.clear()
            field.addAll(listNotes)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_data_produk, parent, false)
        return ProdukViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
        holder.bind(listProduk[position])
    }

    override fun getItemCount(): Int = listProduk.size

    inner class ProdukViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CardDataProdukBinding.bind(itemView)

        fun bind(produk: Produk) {
            binding.tvNamaProduk.text = produk.namaProduk
            binding.tvHarga.text = produk.hargaJual.toString()
            binding.tvHargaAsli.text = produk.hargeAwal.toString()
            if (produk.isFav) {
                binding.favorite.setImageResource(R.drawable.fav_fill)
            }

        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(selectedProduk: Produk?, position: Int?)
    }

    fun addItem(produk: Produk) {
        listProduk.add(produk)
        notifyItemInserted(listProduk.size - 1)
    }

    fun updateItem(position: Int, produk: Produk) {
        listProduk[position] = produk
        notifyItemChanged(position, produk)
    }

    fun removeItem(position: Int) {
        listProduk.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, listProduk.size)
    }
}
