package com.example.payoo.helper

import android.database.Cursor
import com.example.payoo.db.DatabaseContract
import com.example.payoo.entity.Produk

object MappingHelper {

    fun mapCursorToArrayList(produkCursor: Cursor?): ArrayList<Produk> {
        val notesList = ArrayList<Produk>()
        produkCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.ProdukColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.ProdukColumns.namaProduk))
                val description = getInt(getColumnIndexOrThrow(DatabaseContract.ProdukColumns.hargaJual))
                val date = getInt(getColumnIndexOrThrow(DatabaseContract.ProdukColumns.hargaBeli))
                notesList.add(Produk(id, title, description, date))
            }
        }
        return notesList
    }
}