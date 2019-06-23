package com.example.rostislav.grocerylist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.selection.SelectionTracker
import com.example.rostislav.grocerylist.ProductAdapter.*

class ProductAdapter(val productList: MutableList<Product>)
    : RecyclerView.Adapter<ProductHolder>() {

    lateinit var tracker: SelectionTracker<Product>

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int) = ProductHolder (
        LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.product_holder,viewGroup,false)
    )



    override fun onBindViewHolder(productHolder: ProductHolder, position: Int) = Unit

    override fun onBindViewHolder(productHolder: ProductHolder, position: Int , payloads: List<Any>) {

        productHolder.setActivatedState(tracker.isSelected(productList[position]))

        if (SelectionTracker.SELECTION_CHANGED_MARKER !in payloads) {
            productHolder.changeProduct(productList[position])
        }


    }


    override fun getItemCount() = productList.size

    inner class ProductHolder (itemView: View) : RecyclerView.ViewHolder(itemView) , ViewHolderWithDetails<Product> {

        override fun getItemDetail() = ProductDetails(adapterPosition, productList.getOrNull(adapterPosition))

        fun setActivatedState(isActivated: Boolean) {
            itemView.isActivated = isActivated
        }

        val nameHolder: TextView = itemView.findViewById(R.id.name_holder)
        val priceHolder: TextView = itemView.findViewById(R.id.price_holder)

        fun changeProduct(product: Product) {
            nameHolder.text = product.name
            priceHolder.text = product.price.toString()

        }


    }

}


