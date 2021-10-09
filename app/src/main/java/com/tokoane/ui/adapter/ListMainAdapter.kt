package com.tokoane.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tokoane.R
import com.tokoane.data.model.Product

class ListMainAdapter(
    private val context: Context,
    private val product: List<Product>,
    private val listener: ((Product) -> Unit)? = null
) : RecyclerView.Adapter<ListMainAdapter.ListMainViewHolder>() {
    class ListMainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id_product =
            view.findViewById<com.google.android.material.textview.MaterialTextView>(R.id.list_detail_idTv)
        val  photo_product =
            view.findViewById<com.google.android.material.imageview.ShapeableImageView>(R.id.list_detail_fotoIv)
        val  title_product =
            view.findViewById<com.google.android.material.textview.MaterialTextView>(R.id.list_detail_titleTv)
        val description_product =
            view.findViewById<com.google.android.material.textview.MaterialTextView>(R.id.list_detail_descriptionTv)
        val price_product =
            view.findViewById<com.google.android.material.textview.MaterialTextView>(R.id.list_detail_priceTv)

        fun bindView(product: Product, listener: ((Product) -> Unit)? = null) {
            id_product.text = product.id.toString()
            photo_product.setImageResource(product.photo)
            title_product.text = product.title
            description_product.text = product.description
            price_product.text = product.price
            itemView.setOnClickListener {
                if (listener != null) {
                    listener(product)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMainViewHolder =
        ListMainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_main, parent, false))

    override fun getItemCount(): Int = product.size

    override fun onBindViewHolder(holder: ListMainViewHolder, position: Int) {
        if (listener != null) {
            holder.bindView(product[position], listener)
        }else{
            holder.bindView(product[position])
        }
    }
}