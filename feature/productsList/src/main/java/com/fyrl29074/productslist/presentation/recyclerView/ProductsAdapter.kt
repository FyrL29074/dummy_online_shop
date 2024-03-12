package com.fyrl29074.productslist.presentation.recyclerView

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fyrl29074.productslist.databinding.ItemProductBinding
import com.fyrl29074.productslist.domain.model.Product

class ProductsAdapter(
) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    private var products: List<Product> = emptyList()

    // TODO: add diffUtil
    @SuppressLint("NotifyDataSetChanged")
    fun updateProducts(newProducts: List<Product>) {
        products = newProducts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = products[position]
        holder.binding.apply {
            Glide.with(thumbnail)
                .load(product.thumbnail)
                .error(android.R.drawable.ic_dialog_alert)
                .into(thumbnail)
            title.text = product.title
            description.text = product.description
        }
    }

    inner class ProductsViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)
}