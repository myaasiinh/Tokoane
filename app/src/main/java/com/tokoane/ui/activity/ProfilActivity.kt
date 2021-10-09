package com.tokoane.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textview.MaterialTextView
import com.tokoane.R

class ProfilActivity : AppCompatActivity(R.layout.activity_profile) {

    companion object{
        fun start(context: Context) {
            val intent = Intent(context, ProfilActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var backButton: ImageButton
    private lateinit var sp: SharedPreferences
    private lateinit var nameET: MaterialTextView
    lateinit var emailET: MaterialTextView
    private lateinit var keluarTv: MaterialTextView
    private lateinit var lokasiTv: MaterialTextView

    @SuppressLint("SetTextI18n")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        backButton = findViewById(R.id.back_btnIb)
        backButton.setOnClickListener { super@ProfilActivity.onBackPressed() }

        nameET = findViewById(R.id.fullnameProfilEt)
        emailET = findViewById(R.id.emailProfilEt)
        keluarTv = findViewById(R.id.keluarTv)
        lokasiTv = findViewById(R.id.lokasitokoTv)

        lokasiTv.setOnClickListener {
            val url = "https://maps.app.goo.gl/giFvSbkVhE2vnksu8"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        sp = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE)
        val name = sp.getString("NAME", null)
        val email = sp.getString("EMAIL", null)
        if (email != null) {
            emailET.text = "$email"
        }
        if (name != null) {
            Toast.makeText(this, "Selamat datang $name", Toast.LENGTH_SHORT).show()
            nameET.text = "$name"
        }

        keluarTv.setOnClickListener {
            sp.edit().putBoolean("ISLOGGEDIN", true).apply()
            startLogin()
            finish()
        }

    }

    private fun startLogin() {
        LoginActivity.start(this)
    }
}
