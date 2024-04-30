//package com.example.payoo
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class CardInfoAdapter(private val dataList: List<CardItem>) : RecyclerView.Adapter<CardProdukAdapter.ViewHolder>() {
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val titleTextView: TextView = itemView.findViewById(R.id.judul_card)
//        val totalTextView: TextView = itemView.findViewById(R.id.Total)
//        val jumlahTextView: TextView = itemView.findViewById(R.id.Jumlah)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_info, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = dataList[position]
//        holder.titleTextView.text = item.title
//        holder.totalTextView.text = item.total
//        holder.jumlahTextView.text = item.jumlah
//    }
//
//    override fun getItemCount(): Int {
//        return dataList.size
//    }
//}
