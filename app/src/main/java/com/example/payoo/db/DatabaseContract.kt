package com.example.payoo.db

import android.provider.BaseColumns

class DatabaseContract {

    internal class ProdukColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "produk"
            const val _ID = "_id"
            const val namaProduk = "namaProduk"
            const val hargaJual= "hargaJual"
            const val hargaBeli = "hargaBeli"
            const val isFav="isFav"
        }
    }
}