package com.tokoane.ui.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tokoane.R
import com.tokoane.data.local.SharedPref
import com.tokoane.data.model.Product
import com.tokoane.ui.adapter.ListMainAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val sp: SharedPreferences? = null

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
        lateinit var list_product:List<Product>

        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailcartbtn: androidx.appcompat.widget.AppCompatImageButton =
            findViewById(R.id.detailcartIb)

        val detailprofilebtn: androidx.appcompat.widget.AppCompatImageButton =
            findViewById(R.id.detailprofileIb)

        detailcartbtn.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        detailprofilebtn.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        }

        onResume()

        list_product = listOf(

             Product(
                1,
                R.drawable.logosoto,
                 "sepatu nike zoom 1 pro limited edition",
                 "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                 "Rp 300, 000"


                ),

             Product(
                2,
                 R.drawable.logosoto,
                 "sepatu nike zoom 1 pro limited edition",
                 "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                 "Rp 150, 000"


                ),

             Product(
                3,
                 R.drawable.logosoto,
                 "sepatu nike zoom 1 pro limited edition",
                 "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                 "Rp 200, 000"

                ),

             Product(
                4,
                 R.drawable.logosoto,
                 "sepatu nike zoom 1 pro limited edition",
                 "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                 "Rp 250, 000"


                ),

             Product(
                5,
                 R.drawable.logosoto,
                 "sepatu nike zoom 1 pro limited edition",
                 "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                 "Rp 350, 000"


                ),

             Product(
                6,
                 R.drawable.logosoto,
                 "sepatu nike zoom 1 pro limited edition",
                 "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                 "Rp 300, 000, 000, 000"


                ),

             Product(
                7,
                 R.drawable.logosoto,
                 "sepatu nike zoom 1 pro limited edition",
                 "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                 "Rp 450, 000"


                ),

             Product(
                8,
                 R.drawable.logosoto,
                 "sepatu nike zoom 1 pro limited edition",
                 "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                 "Rp 400, 000"


                ),

             Product(
                9,
                 R.drawable.logosoto,
                 "sepatu nike zoom 1 pro limited edition",
                 "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                 "Rp 550, 000"

                ),

             Product(
                10,
                 R.drawable.logosoto,
                 "sepatu nike zoom 1 pro limited edition",
                 "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                 "Rp 500, 000"

                ),
            Product(
                11,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 650, 000"
            ),
            Product(
                12,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 600, 000"
            ),
            Product(
                13,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 700, 000"
                ),
            Product(
                14,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 750, 000"
                ),
            Product(
                15,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 850, 000"
            ),
            Product(
                16,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 800, 000"
            ),
            Product(
                17,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 950, 000"
            ),
            Product(
                16,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 1.500, 000"
            ),
            Product(
                17,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 1.000, 000"
            ),
            Product(
                18,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 2.000, 000"
            ),
            Product(
                19,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 2.500, 000"
            ),
            Product(
                20,
                R.drawable.logosoto,
                "sepatu nike zoom 1 pro limited edition",
                "sepatu nike zoom warna merah ukuran xl untuk anak laki - laki atau bisa juga untuk remaja berusia dua belas tahun oke dehhh",
                "Rp 3.000, 000"
            )

            )

        val recyclerView = findViewById<RecyclerView>(R.id.recylerviewhome)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ListMainAdapter(this, list_product) {
            val intent = Intent(this, DetailActivityMain::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }

        fun startLogin() {
            LoginActivity.start(this)
        }

        fun onResume() {
            super.onResume()
            Log.d("TAG", "onResume: " + SharedPref.GetId(this))
            sp!!.edit().putBoolean("ISLOGGEDIN", false).apply()
            startLogin()
            finish()

        }

    }
}