package com.kushalsharma.tent.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.kushalsharma.tent.DataMind
import com.kushalsharma.tent.R


class mindAdapter(
    options: FirestoreRecyclerOptions<DataMind>,
    val listner: mClickAdapter, val cartListner: mBtnClickAdapter
) :
    FirestoreRecyclerAdapter<DataMind, mindAdapter.mindViewHolder>(
        options
    ) {
    class mindViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.textt1)
        val tvPrice: TextView = itemView.findViewById(R.id.textt2)
        val cartButton: Button = itemView.findViewById(R.id.itemCartBtn)
//        val ibImage : ImageView = itemView.findViewById(R.id.imagee)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mindViewHolder {


        val viewholder = mindViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        )
        viewholder.tvName.setOnClickListener {
            Log.d("hey", "is tisflkjasljfla$$$$$$$")

            listner.onbtnClicked(
                snapshots.getSnapshot(viewholder.adapterPosition).id,
                snapshots.getSnapshot(viewholder.adapterPosition).id
            )
        }

        viewholder.cartButton.setOnClickListener {
            cartListner.onCartBtnClicked()

        }



        return viewholder
    }

    override fun onBindViewHolder(holder: mindViewHolder, position: Int, model: DataMind) {

        holder.tvName.text = model.itemName
        holder.tvPrice.text = model.itemPrice
//        Glide.with(holder.ibImage.context).load(model.itemImageUrl).into(holder.ibImage)

    }
}

interface mClickAdapter {

    fun onbtnClicked(itemId: String, itemPrice: String)
}

interface mBtnClickAdapter {
    fun onCartBtnClicked()
}
