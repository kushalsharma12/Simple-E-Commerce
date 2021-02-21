package com.kushalsharma.tent.dao

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.Dispatchers
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.coroutines.launch
import com.google.android.gms.tasks.Task

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kushalsharma.tent.models.Order
import com.kushalsharma.tent.models.User
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
class orderDao {

    val db = FirebaseFirestore.getInstance()
    val orderCollection = db.collection("orders")
    val auth = Firebase.auth

    fun addOrder(itemName : String, itemPrice : String)
    {
        GlobalScope.launch {
            val currentUserId = auth.currentUser!!.uid
            val userDao = UserDao()
            val user = userDao.getUserById(currentUserId).await().toObject(User::class.java)!!

            val currentTime = System.currentTimeMillis()
            val order = Order(itemName,user,currentTime,itemPrice)
            orderCollection.document().set(order)

        }
    }
    fun getOrderById(orderId: String): Task<DocumentSnapshot> {
        return orderCollection.document(orderId).get()
    }

}