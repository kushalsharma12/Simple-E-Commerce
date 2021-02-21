package com.kushalsharma.tent.dao

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import com.google.firebase.firestore.DocumentSnapshot
import com.kushalsharma.tent.models.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.w3c.dom.Document
import android.app.DownloadManager
import androidx.core.app.TaskStackBuilder
import com.google.android.gms.tasks.Task

class UserDao {

    private val db = FirebaseFirestore.getInstance()
    private val userCollection = db.collection("users")

    fun addUser(user : User?){
        user?.let{
            GlobalScope.launch(Dispatchers.IO)
            {
                userCollection.document(user.uid).set(it)
            }
        }
    }
    fun getUserById(uid : String) : Task<DocumentSnapshot>{
        return userCollection.document(uid).get()
    }
}