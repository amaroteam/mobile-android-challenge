package com.test.amaro.amarotest.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.test.amaro.amarotest.R
import com.test.amaro.amarotest.models.Product
import kotlinx.android.synthetic.main.toolbar.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val product = intent.getParcelableExtra<Product>("product")
        val nameTextView = findViewById<TextView>(R.id.text_name)
        val priceTextView = findViewById<TextView>(R.id.text_price)
        val promotionTextView = findViewById<TextView>(R.id.text_promotion)
        val promotionalPriceTextView = findViewById<TextView>(R.id.text_promotional_price)
        val image = findViewById<ImageView>(R.id.image)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Set Collapsing Toolbar layout to the screen

        val upArrow = resources.getDrawable(R.drawable.ic_arrow_back_white_24dp)
        supportActionBar!!.setHomeAsUpIndicator(upArrow)

        nameTextView.text = product.name
        priceTextView.text = product.regularPrice
        promotionTextView.text = product.discountPercentage
        promotionalPriceTextView.text = product.actualPrice
        Picasso.with(this).load(product.image).into(image)
    }
}
