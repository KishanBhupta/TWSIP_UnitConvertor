package com.example.unit_calculation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unit_calculation.adaptor.CategoryAdaptor
import com.example.unit_calculation.supportclass.Category
import com.example.unit_calculation.supportclass.Common

class MainActivity : AppCompatActivity() {
    private lateinit var recylerview: RecyclerView
    private lateinit var commonAdaptor: CategoryAdaptor
    private lateinit var commonList: ArrayList<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Int()
    }

    fun Int(){
        recylerview = findViewById(R.id.recyclerview)

        // list of main category
        commonList = arrayListOf(
            Category(name = "Speed", unit = Common.Speed().getUnit(), image = R.drawable.baseline_speed_24),
            Category(name = "Area", unit = Common.Area().getUnit(), image = R.drawable.baseline_area_chart_24),
            Category(name = "Temperature", unit = Common.Temperature().getUnit(), image = R.drawable.baseline_device_thermostat_24),
            Category(name = "Mass", unit = Common.Mass().getUnits(), image = R.drawable.mass_24)
        )

        commonAdaptor = CategoryAdaptor(arrayList = commonList, context = applicationContext)
        recylerview.layoutManager = GridLayoutManager(applicationContext,2,GridLayoutManager.VERTICAL,false)
        recylerview.setHasFixedSize(false)
        recylerview.adapter = commonAdaptor

    }
}