package com.kushalsharma.tent

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Fade
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.kushalsharma.tent.adapters.mBtnClickAdapter
import com.kushalsharma.tent.adapters.mClickAdapter
import com.kushalsharma.tent.adapters.mindAdapter
import com.kushalsharma.tent.dao.orderDao
import kotlinx.android.synthetic.main.activity_mind.*


class mind : AppCompatActivity(), mClickAdapter, mBtnClickAdapter {

    val db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth
    private lateinit var orderDao: orderDao


    private lateinit var adapter : mindAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mind)

        auth = Firebase.auth
        orderDao = orderDao()

        setupRecycle()




    }

    private fun setupRecycle() {

        val query = db.collection("products")
            .orderBy("itemName").limit(50)

        val options =
            FirestoreRecyclerOptions.Builder<DataMind>().setQuery(query, DataMind::class.java)
                .setLifecycleOwner(this).build()

        adapter = mindAdapter(options, this, this)

        mindRecycleView.adapter = adapter
        mindRecycleView.layoutManager = LinearLayoutManager(this)


    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }
    

    override fun onbtnClicked(itemId: String, itemPrice: String) {
        Log.d("hey000", "is 00000000tisflkjasljfla$$$$$$$")
        orderDao.addOrder(itemId, "")

        Toast.makeText(this, "hello from the jungle", Toast.LENGTH_SHORT).show()

    }

    @SuppressLint("WrongConstant")
    override fun onCartBtnClicked() {

        val snackbar = Snackbar
            .make(constrLay, "TENT || Check out the cart to order", Snackbar.LENGTH_INDEFINITE)
            .setAction("View Cart", View.OnClickListener {
                val intent = Intent(this, cart::class.java)
                startActivity(intent)
            })
        .setActionTextColor(Color.RED)
            .setBackgroundTint(Color.YELLOW)
            .setTextColor(Color.BLUE)
            .setAnimationMode(Fade.MATCH_INSTANCE)


        .show()


    }


}