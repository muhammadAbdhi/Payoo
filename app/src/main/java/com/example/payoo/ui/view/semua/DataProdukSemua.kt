package com.example.payoo.ui.view.semua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.payoo.R
import com.example.payoo.db.DatabaseHelper
import com.example.payoo.entity.Produk
import com.example.payoo.ui.view.adapter.ProdukAdapter

class DataProdukSemua : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cardProdukAdapter: ProdukAdapter
    private val dataList = mutableListOf<Produk>()
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_data_produk_semua, container, false)
        recyclerView = view.findViewById(R.id.rv_company)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        cardProdukAdapter = ProdukAdapter(dataList)
        recyclerView.adapter = cardProdukAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databaseHelper = DatabaseHelper(requireContext())
        dataList.addAll(databaseHelper.getAllProducts())
        cardProdukAdapter.notifyDataSetChanged()
    }
}
