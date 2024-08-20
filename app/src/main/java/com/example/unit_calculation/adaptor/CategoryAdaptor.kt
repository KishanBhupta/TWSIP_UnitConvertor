package com.example.unit_calculation.adaptor

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.unit_calculation.R
import com.example.unit_calculation.calculations
import com.example.unit_calculation.supportclass.Category

    class CategoryAdaptor(private val arrayList: ArrayList<Category>, private val context: Context) : RecyclerView.Adapter<CategoryAdaptor.CategoryViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.category ,parent,  false)
            return CategoryViewHolder(view)
        }

        override fun getItemCount(): Int {
            return  arrayList.size
        }

        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
            holder.image.setImageResource(arrayList[position].image)
            holder.name.setText(arrayList[position].name)
            holder.category.setOnClickListener{
                val intent  = Intent(context ,calculations::class.java )
                intent.putExtra("units",arrayList[position].unit)
                intent.putExtra("name",arrayList[position].name)
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)

            }
        }
        class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val image: ImageView = itemView.findViewById(R.id.categoryImage)
            val name : TextView = itemView.findViewById(R.id.categoryName)
            val category: CardView = itemView.findViewById(R.id.category)
        }
    }
