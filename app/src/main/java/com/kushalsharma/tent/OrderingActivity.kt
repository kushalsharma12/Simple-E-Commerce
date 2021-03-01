package com.kushalsharma.tent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kushalsharma.tent.dao.orderDao
import kotlinx.android.synthetic.main.activity_ordering.*


class OrderingActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var orderDao: orderDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordering)

        auth = Firebase.auth
        orderDao = orderDao()

        orderButton2.setOnClickListener {
            val inputItem = item2.text.toString().trim()
            val inputPrice = item1Price.text.toString().trim()

            orderDao.addOrder(inputItem, inputPrice)

            Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show()
        }

        orderButton3.setOnClickListener {
            val inputItem2 = item3.text.toString().trim()
            val inputPrice2 = item3Price.text.toString().trim()

            orderDao.addOrder(inputItem2, inputPrice2)

            val snackbar = Snackbar
                .make(constraintlayout, "www.journaldev.com", Snackbar.LENGTH_LONG)
                .setAction("View Cart", View.OnClickListener {
                    val intent = Intent(this, cart::class.java)
                    startActivity(intent)
                })
                .show()
            Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show()
        }

        buttonToAlpha.setOnClickListener {
            val inten = Intent(this, time::class.java)
            startActivity(inten)
        }
        buttonToCenturai.setOnClickListener {
            val inten = Intent(this, mind::class.java)
            startActivity(inten)
        }



    }


}