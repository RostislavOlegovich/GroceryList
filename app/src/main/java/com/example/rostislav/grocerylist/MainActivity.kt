package com.example.rostislav.grocerylist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMilk: Button = findViewById(R.id.button_milk)
        val buttonFruits: Button = findViewById(R.id.button_fruits)

        buttonMilk.setOnClickListener(this)
        buttonFruits.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, ProductsActivity::class.java)
        when(v?.id){
            R.id.button_milk -> intent.putExtra("productName", "milk")
            R.id.button_fruits -> intent.putExtra("productName", "fruits")
        }
        startActivityForResult(intent, 0)
    }
}
