package com.example.rostislav.grocerylist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ActionMode
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy

class ProductsActivity : AppCompatActivity() {

    var actionMode: ActionMode? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_products)
        val productName = intent.getStringExtra("productName")

        val productAdapter = ProductAdapter(getListOfProducts(productName))
        val linearLayoutManager = LinearLayoutManager(this)

        recyclerView.adapter = productAdapter
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))


        val tracker = SelectionTracker
            .Builder(
                "someId",
                recyclerView,
                ProductKeyProvider(getListOfProducts(productName)),
                ProductLookup(recyclerView),
                StorageStrategy.createParcelableStorage(Product::class.java)
            ).build()

        productAdapter.tracker = tracker

        tracker.addObserver(object : SelectionTracker.SelectionObserver<Any>() {
            override fun onSelectionChanged() {
                super.onSelectionChanged()
                if (tracker.hasSelection() && actionMode == null) {
                    actionMode = startActionMode(ActionModeController(tracker))
                    setSelectedTitle(tracker.selection.size())
                } else if (!tracker.hasSelection()) {
                    actionMode?.finish()
                    actionMode = null
                } else {
                    setSelectedTitle(tracker.selection.size())
                }
            }
        })

    }

    private fun setSelectedTitle(selected: Int) {
        actionMode?.title = "Selected: $selected"
    }



    private fun getListOfProducts(productName: String) =

        when(productName){
            "milk" -> mutableListOf(
                Product("Молоко", 22),
                Product("Кефир", 25),
                Product("Ряжанка", 34),
                Product("Сметана", 18),
                Product("Закваска", 31),
                Product("Топленое молоко", 25),
                Product("Йогурт", 24),
                Product("Масло", 68),
                Product("Сливки", 74),
                Product("Творог", 36),
                Product("Сыр", 45)
                )

            else -> mutableListOf(
                Product("Яблоко", 8),
                Product("Груша", 15),
                Product("Апельсин", 19),
                Product("Лимон", 14),
                Product("Банан", 32),
                Product("Ананас", 30),
                Product("Персик", 45),
                Product("Абрикос", 37),
                Product("Слива", 54),
                Product("Айва", 67),
                Product("Манго", 84),
                Product("Киви", 32)

                )
        }

}
