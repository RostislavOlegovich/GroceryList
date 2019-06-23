package com.example.rostislav.grocerylist

import androidx.recyclerview.selection.ItemDetailsLookup

interface ViewHolderWithDetails<TItem> {

    fun getItemDetail(): ItemDetailsLookup.ItemDetails<TItem>

}