package com.example.payoo.db

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.payoo.db.DatabaseContract.ProdukColumns.Companion.TABLE_NAME
import com.example.payoo.entity.Produk

class DatabaseHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object {
        private const val DATABASE_NAME = "dbproduk"
        private const val DATABASE_VERSION = 1
        private const val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME" +
                " (${DatabaseContract.ProdukColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " ${DatabaseContract.ProdukColumns.namaProduk} TEXT NOT NULL," +
                " ${DatabaseContract.ProdukColumns.hargaJual} INTEGER NOT NULL," +
                " ${DatabaseContract.ProdukColumns.hargaBeli} INTEGER NOT NULL," +
                " ${DatabaseContract.ProdukColumns.isFav} INTEGER DEFAULT 0)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    @SuppressLint("Range")
    fun getAllProducts(): ArrayList<Produk> {
        val productList = ArrayList<Produk>()
        val db = this.readableDatabase
        val cursor: Cursor? = db.rawQuery("SELECT * FROM " + DatabaseContract.ProdukColumns.TABLE_NAME, null)
        cursor?.let {
            if (cursor.moveToFirst()) {
                do {
                    val id = cursor.getInt(cursor.getColumnIndex(DatabaseContract.ProdukColumns._ID))
                    val productName = cursor.getString(cursor.getColumnIndex(DatabaseContract.ProdukColumns.namaProduk))
                    val sellPrice = cursor.getInt(cursor.getColumnIndex(DatabaseContract.ProdukColumns.hargaJual))
                    val buyPrice = cursor.getInt(cursor.getColumnIndex(DatabaseContract.ProdukColumns.hargaBeli))
                    val isFavorite = cursor.getInt(cursor.getColumnIndex(DatabaseContract.ProdukColumns.isFav)) == 1
                    val produk = Produk(id, productName, sellPrice, buyPrice, isFavorite)
                    productList.add(produk)
                } while (cursor.moveToNext())
            }
            cursor.close()
        }
        db.close()
        return productList
    }


}
