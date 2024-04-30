package com.example.payoo.ui.authentication

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.payoo.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textViewLink = findViewById<TextView>(R.id.text_link_belum)
        val textLupasandi = findViewById<TextView>(R.id.text_lupa_sandi)
        val text2="Lupa Kata Sandi?"
        val text = "Disini"
        val span2=SpannableString(text2)
        span2.setSpan(UnderlineSpan(),0,text.length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textLupasandi.text=span2

        val spannableString = SpannableString(text)
        spannableString.setSpan(UnderlineSpan(), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textViewLink.text = spannableString
        textViewLink.setOnClickListener {
            navigateToRegistrationPage()
        }
    }
    private fun navigateToRegistrationPage() {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
        overridePendingTransition(
            R.anim.slide_in_fade
            , R.anim.slide_out_top
        )
    }

}