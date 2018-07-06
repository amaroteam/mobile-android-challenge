package com.test.amaro.amarotest.main

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.dpedroza.desafio.ui.main.MainContract
import com.test.amaro.amarotest.R
import com.test.amaro.amarotest.core.BaseActivity
import com.test.amaro.amarotest.models.Product
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter
    private val adapter = MainAdapter(this, { onProductClick(it) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDagger()
        setupToolbar()
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
        best_sellers_recycler_view.layoutManager = LinearLayoutManager(this)
        best_sellers_recycler_view.adapter = adapter
    }

    private fun setupPresenter() {
        presenter.attachView(this)
        presenter.getProducts()
    }

    private fun setupToolbar() {
        toolbar.title = "Amaro"
        toolbar.setTitleTextColor(Color.WHITE)
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
//        val intent = Intent(this, DetailActivity::class.java)
//        intent.putExtra("full_name", item.fullName)
//        intent.putExtra("owner_login", item.owner.login)
//        intent.putExtra("repository_name", item.name)
//        startActivity(intent)
    }

}
