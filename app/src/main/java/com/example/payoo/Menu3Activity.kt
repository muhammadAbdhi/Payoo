package com.example.payoo

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.payoo.databinding.ActivityMenu3Binding
import com.google.android.material.navigation.NavigationView

class Menu3Activity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding:ActivityMenu3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMenu3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = findViewById(R.id.drawer_layout3)

        binding.btnMenu.setOnClickListener {
            drawerLayout.openDrawer(binding.navMenu3)
        }
        val navigationView: NavigationView = findViewById(R.id.nav_menu3)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_produk -> {
                    val intent = Intent(this@Menu3Activity, MainActivity2::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        val dataProduk :LinearLayout=binding.btnDataProduk
        dataProduk.setOnClickListener(handleClick)


    }
    private val handleClick = { v: android.view.View ->
        // Mendapatkan ID LinearLayout yang diklik
        val id = v.id

        // Menjalankan aksi sesuai dengan ID LinearLayout yang diklik
        when (id) {
            R.id.btn_data_produk -> {
                val intent = Intent(this@Menu3Activity, MainActivity2::class.java)
                startActivity(intent)
            }

            // Dan seterusnya untuk setiap LinearLayout
            else -> {}
        }
    }
}