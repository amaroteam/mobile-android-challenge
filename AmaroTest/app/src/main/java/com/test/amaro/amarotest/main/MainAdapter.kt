package com.test.amaro.amarotest.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.test.amaro.amarotest.R
import com.test.amaro.amarotest.models.Product
import kotlinx.android.synthetic.main.product.view.*

class MainAdapter(val context: Context, private val itemClick: (Product) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val products: MutableList<Product> = mutableListOf()

    fun setProducts(list: List<Product>) {
        products.addAll(list)
        notifyItemRangeChanged(itemCount, products.size)
    }

    override fun getItemCount() = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product, parent, false), itemClick)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ProductViewHolder
        viewHolder.bind(products[position])
    }

    inner class ProductViewHolder(view: View, private val itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bind(item: Product) {
            with(item) {

                itemView.text_name.text = item.name
                itemView.text_price.text = item.actualPrice
                itemView.setOnClickListener { itemClick(this) }

                item.image?.let {
                    if (it.isNotEmpty()) {
                        Picasso.with(context)
                            .load(it)
                            .placeholder(R.drawable.ic_account_circle_gray_24dp)
                            .into(itemView.image)
                    }
                }

            }
        }
    }
}
