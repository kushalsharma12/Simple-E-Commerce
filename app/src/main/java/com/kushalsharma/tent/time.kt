package com.kushalsharma.tent


import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_time.*


data class timeModel(

        val itemName: String = "",
        val itemPrice: String = "",
)


class timeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class time : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val query = db.collection("products")
                .orderBy("itemName").limit(50)

        val options =
                FirestoreRecyclerOptions.Builder<timeModel>().setQuery(query, timeModel::class.java)
                        .setLifecycleOwner(this).build()

        val adapter = object : FirestoreRecyclerAdapter<timeModel, timeViewHolder>(options) {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): timeViewHolder {
                val view: View = LayoutInflater.from(this@time).inflate(R.layout.items, parent, false)



                return timeViewHolder(view)
            }

            override fun onBindViewHolder(holder: timeViewHolder, position: Int, model: timeModel) {

                val tvName: TextView = holder.itemView.findViewById(R.id.textt1)
                val tvPrice: TextView = holder.itemView.findViewById(R.id.textt2)
                tvName.text = model.itemName
                tvPrice.text = model.itemPrice


            }

        }
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(this)


    }
}

//interface itemClicked{
//    fun onItemClicked(item : Button)
//}
