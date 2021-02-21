package com.kushalsharma.tent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import com.kushalsharma.tent.dao.orderDao
import kotlinx.android.synthetic.main.activity_ordering.*

class OrderingActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var orderDao : orderDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordering)

        progressBar2.visibility = View.GONE

        auth = Firebase.auth
        orderDao = orderDao()

        orderButton2.setOnClickListener {
            val inputItem = item2.text.toString().trim()
            val inputPrice = item1Price.text.toString().trim()

            orderDao.addOrder(inputItem,inputPrice)

            Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show()
        }
        
        orderButton3.setOnClickListener { 
            val inputItem2 = item3.text.toString().trim()
            val inputPrice2 = item3Price.text.toString().trim()
            
            orderDao.addOrder(inputItem2,inputPrice2)

            Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show()
        }

        log_Out_Button.setOnClickListener {
            Firebase.auth.signOut()

            progressBar2.visibility = View.VISIBLE
            log_Out_Button.visibility = View.GONE
            val logOutIntent = Intent(this,MainActivity::class.java)
            startActivity(logOutIntent)
            finish()
        }

    }
}