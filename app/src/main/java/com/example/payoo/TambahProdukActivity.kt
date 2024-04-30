package com.example.payoo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.payoo.databinding.ActivityTambahProdukBinding
import com.example.payoo.db.ProdukHelper
import com.example.payoo.entity.Produk

class TambahProdukActivity : AppCompatActivity()  {
    private lateinit var mAdapter: CardListKomposisiAdapter
    private var isEdit = false
    private var produk: Produk? = null
    private var position: Int = 0
    private lateinit var produkHelper: ProdukHelper
    private lateinit var binding: ActivityTambahProdukBinding
    private lateinit var spinner1: Spinner
    private lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)
         spinner1= findViewById(R.id.spinner_komposisi)
        rv=binding.rvListKomposisi

        spinner1.onItemSelectedListener = ItemSelectedListener()

    }
    inner class ItemSelectedListener : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
            val firstItem = spinner1.selectedItem.toString()
            if (firstItem == spinner1.selectedItem.toString()) {
                // Do nothing
            } else {
                val selectedItem = parent?.getItemAtPosition(pos).toString()
                when (selectedItem) {
                    "Apel" ->  mAdapter= CardListKomposisiAdapter( listOf(KomposisiItem("1","Keju",12)))
                }
//            val dataBaru: List<KomposisiItem> = generateDataBaru(selectedItem)

//            mAdapter.updateData(dataBaru)
            }
        }

        override fun onNothingSelected(arg: AdapterView<*>?) {
        }
//        private fun generateDataBaru(selectedItem: String): List<KomposisiItem> {
//            return when (selectedItem) {
//                "Apel" -> listOf(KomposisiItem("1","Keju",12))
//                else -> listOf()
//            }
//        }
    }



}