package com.example.rostislav.grocerylist

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup

class ProductLookup(private val recyclerView: RecyclerView) : ItemDetailsLookup<Product>() {

    override fun getItemDetails(e: MotionEvent) = recyclerView.findChildViewUnder(e.x, e.y)
        ?.let {
            (recyclerView.getChildViewHolder(it) as? ViewHolderWithDetails<Product>)?.getItemDetail()
        }

}