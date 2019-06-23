package com.example.rostislav.grocerylist

import androidx.recyclerview.selection.ItemDetailsLookup

class ProductDetails(private val adapterPosition: Int, private val selectedKey: Product?) : ItemDetailsLookup.ItemDetails<Product>() {

    override fun getSelectionKey() = selectedKey

    override fun getPosition() = adapterPosition

}