package com.kushalsharma.tent.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.kushalsharma.tent.DataMind
import com.kushalsharma.tent.R
import com.kushalsharma.tent.dao.orderDao
import kotlinx.android.synthetic.main.activity_ordering.*

class mindAdapter(options: FirestoreRecyclerOptions<DataMind>, val listner: mClickAdapter) :
    FirestoreRecyclerAdapter<DataMind, mindAdapter.mindViewHolder>(
        options)


        {


            class mindViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val tvName: TextView = itemView.findViewById(R.id.textt1)
        val tvPrice: TextView = itemView.findViewById(R.id.textt2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mindViewHolder {


        val viewholder = mindViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        )
        viewholder.tvName.setOnClickListener {
            Log.d("hey", "is tisflkjasljfla$$$$$$$")




            listner.onbtnClicked(snapshots.getSnapshot(viewholder.adapterPosition).id)
        }

        return viewholder
    }

    override fun onBindViewHolder(holder: mindViewHolder, position: Int, model: DataMind) {

        holder.tvName.text = model.itemName
        holder.tvPrice.text = model.itemPrice

    }
}

interface mClickAdapter {

    fun onbtnClicked(itemId: String)
}