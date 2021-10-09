package com.tokoane.ui.activity

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.tokoane.R
import com.tokoane.data.local.SharedPref
import com.tokoane.data.model.Product

class DetailActivityMain : AppCompatActivity(R.layout.detail_activity_main) {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val backButton: ImageButton =
            findViewById(R.id.back_btnIb)

        val itemProduct = intent.getParcelableExtra<Product>(MainActivity.INTENT_PARCELABLE)
        val photoProduct:com.google.android.material.imageview.ShapeableImageView
                = findViewById(R.id.photo_productSv)

        val titleProduct:com.google.android.material.textview.MaterialTextView
                = findViewById(R.id.title_productTv)

        val hargaProdut:com.google.android.material.textview.MaterialTextView
                = findViewById(R.id.price_productTv)

        val idProduct:com.google.android.material.textview.MaterialTextView
                = findViewById(R.id.id_productTv)

        val descriptionProduct: com.google.android.material.textview.MaterialTextView
        = findViewById(R.id.description_productTv)

        val btnBuy =
            findViewById<androidx.appcompat.widget.AppCompatImageButton>(R.id.buy_btnIb)

        if (itemProduct != null) {
            photoProduct.setImageResource(itemProduct.photo)
        }

        if (itemProduct != null) {
            idProduct.text = itemProduct.id.toString()
        }

        if (itemProduct != null) {
            titleProduct.text = itemProduct.title
        }

        if (itemProduct != null) {
            descriptionProduct.text = itemProduct.description
        }

        if (itemProduct != null) {
            hargaProdut.text = itemProduct.price
        }

        btnBuy.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi pesanan")
            builder.setMessage("Beli produk ini sekarang?")
            builder.setNegativeButton("Tidak") { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    "Tidak jadi beli", Toast.LENGTH_SHORT
                ).show()
            }
            builder.setPositiveButton("Ya") { dialog, which ->
                if (itemProduct != null) {
                    SharedPref.SaveId(this, "{\"id\":\"" + itemProduct.id.toString() + "\", \"photo\":\"" + itemProduct.photo.toString() + "\", \"title\":\"" + itemProduct.title + "\", \"description\":\"" + itemProduct.description + "\",  \"price\":\"" + itemProduct.price + "\"}")
                    /*
                    val intent = Intent(this@DetailActivityMain, CartActivity::class.java)
                    startActivity(intent)

                     */
                    Toast.makeText(this,"Terima kasih pesanan anda diproses", Toast.LENGTH_SHORT).show()
                }
            }
            builder.show()

        }

        backButton.setOnClickListener {
            super.onBackPressed()
        }

    }
}