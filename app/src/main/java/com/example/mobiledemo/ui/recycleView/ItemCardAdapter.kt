package com.example.mobiledemo.ui.recycleView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiledemo.R


class ItemCardAdapter(private val context: Context?,
                      private val dataset: List<ItemCard>
):
    RecyclerView.Adapter<ItemCardAdapter.ItemCardViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardViewHolder {
        // condicional
        if(viewType == 0)
        {
            val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item,  parent, false)
            return ItemCardViewHolder(adapterLayout)
        }else{
            val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item2,  parent, false)
            return ItemCardViewHolder(adapterLayout)
        }


    }

    override fun getItemViewType(position: Int): Int {

        if(position % 2 == 0){
            return 0
        }else{
            return 1
        }
    }

    override fun onBindViewHolder(holder: ItemCardViewHolder, position: Int) {
        val item = dataset[position]
        holder.decripcion.text = item.descripcion
        holder.tiempo.text = item.time
        holder.cardView.setOnClickListener {
            Toast.makeText(context, "Haz hecho click", Toast.LENGTH_SHORT).show()
            //val context = holder.view.context
            //val intent: Intent = Intent(context, Article::class.java)
            //context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    // ViewHolder
    class ItemCardViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val decripcion: TextView = view.findViewById(R.id.item_tittle)
        val tiempo: TextView = view.findViewById(R.id.item_time)
        val cardView: CardView = view.findViewById(R.id.cardView)

    }

}