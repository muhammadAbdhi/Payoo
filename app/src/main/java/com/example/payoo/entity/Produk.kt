package com.example.payoo.entity
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Produk(
    var id: Int = 0,
    var namaProduk: String? = null,
    var hargaJual: Int = 0,
    var hargeAwal: Int = 0,
    var isFav: Boolean =false,
            ) : Parcelable
