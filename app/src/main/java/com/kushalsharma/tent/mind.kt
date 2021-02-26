package com.kushalsharma.tent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.kushalsharma.tent.adapters.mClickAdapter
import com.kushalsharma.tent.adapters.mindAdapter
import kotlinx.android.synthetic.main.activity_mind.*

class mind : AppCompatActivity(), mClickAdapter {

    val db = FirebaseFirestore.getInstance()


    private lateinit var adapter : mindAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mind)


        setupRecycle()
    }

    private fun setupRecycle() {

        val query = db.collection("products")
            .orderBy("itemName").limit(50)

        val options =
            FirestoreRecyclerOptions.Builder<DataMind>().setQuery(query, DataMind::class.java)
                .setLifecycleOwner(this).build()

        adapter = mindAdapter(options,this)

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

    override fun onbtnClicked(itemId: String) {

        Log.d("hey000","is 00000000tisflkjasljfla$$$$$$$")

        Toast.makeText(this, "hello from the jungle", Toast.LENGTH_SHORT).show()
    }
}