package com.example.payoo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.payoo.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.bottomNavigation
        val addProduk=binding.btnAddProduk
        addProduk.setOnClickListener{
            val intent = Intent(this@MainActivity2, TambahProdukActivity::class.java)
            startActivity(intent)
            true
        }
    }
}