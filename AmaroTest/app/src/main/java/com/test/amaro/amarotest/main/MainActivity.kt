package com.test.amaro.amarotest.main

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import com.test.amaro.amarotest.R
import com.test.amaro.amarotest.core.BaseActivity
import com.test.amaro.amarotest.detail.DetailActivity
import com.test.amaro.amarotest.models.Product
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter
    private val adapter = MainAdapter(this, { onProductClick(it) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDagger()
        setupPresenter()
        setupRecyclerView()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
//        outState?.putParcelableArrayList("repositories_list", adapter.repositoriesList as ArrayList<out Parcelable>)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
//        adapter.setProducts(savedInstanceState.getParcelableArrayList<Item>("repositories_list") as List<Item>)
    }

    private fun setupDagger() {
        activityComponent.inject(this)
    }

    private fun setupRecyclerView() {
        best_sellers_recycler_view.layoutManager = GridLayoutManager(this, 2)
        best_sellers_recycler_view.adapter = adapter
    }

    private fun setupPresenter() {
        presenter.attachView(this)
        presenter.getProducts()
    }

    override fun showProducts(products: List<Product>) {
        adapter.setProducts(products)
    }

    override fun retry() {
        presenter.getProducts()
    }

    override fun onLoadStarted() {
//        loadDialog?.show()
    }

    override fun onLoadFinished() {
//        loadDialog?.dismiss()
    }

    override fun onShowError(errorMessage: String) {
        Snackbar.make(findViewById(android.R.id.content), errorMessage, Snackbar.LENGTH_INDEFINITE)
            .setAction("Tentar Novamente", { retry() })
            .show()
    }

    private fun onProductClick(item: Product): Unit {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("product", item)
        startActivity(intent)
    }

}
