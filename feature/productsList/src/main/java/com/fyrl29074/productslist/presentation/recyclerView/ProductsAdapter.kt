package com.fyrl29074.productslist.presentation.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fyrl29074.productslist.databinding.ItemProductBinding
import com.fyrl29074.productslist.domain.model.Product

class ProductsAdapter :
    PagingDataAdapter<Product, ProductsAdapter.ProductsViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = getItem(position)
        holder.binding.apply {
            Glide.with(thumbnail)
                .load(product?.thumbnail)
                .error(android.R.drawable.ic_dialog_alert)
                .into(thumbnail)
            title.text = product?.title ?: ""
            description.text = product?.description ?: ""
        }
    }

    inner class ProductsViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)
}

class DiffUtilCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem == newItem
}
