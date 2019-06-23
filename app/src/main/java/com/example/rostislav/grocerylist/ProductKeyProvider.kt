package com.example.rostislav.grocerylist

import androidx.recyclerview.selection.ItemKeyProvider

class ProductKeyProvider( private  val items: MutableList<Product>)
    : ItemKeyProvider<Product>(ItemKeyProvider.SCOPE_CACHED) {

    override fun getKey(position: Int) = items.getOrNull(position)
    override fun getPosition(key: Product) = items.indexOf(key)

}


