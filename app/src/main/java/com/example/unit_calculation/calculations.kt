package com.example.unit_calculation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.unit_calculation.supportclass.Common
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.log

class calculations : AppCompatActivity() {
    private lateinit var fromSplinner: Spinner
    private lateinit var fromInputEditText: TextInputEditText
    private lateinit var toSplinner: Spinner
    private lateinit var toInputEditText: TextInputEditText
    private lateinit var backBtn: ImageView
    lateinit var fromUnit: String
    lateinit var toUnit: String
    lateinit var category:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculations)

        Init()
    }

    fun Init(){

        fromSplinner = findViewById(R.id.CalFromSpliner)
        toSplinner = findViewById(R.id.CalToSpliner)
        fromInputEditText = findViewById(R.id.CalEditTextFrom)
        toInputEditText = findViewById(R.id.CalEditTextTo)
        backBtn = findViewById(R.id.calBackBtn)

        // create a object of getData from intent

        val intent = intent

        // get and store category array data

        val unit:ArrayList<String> = intent.getSerializableExtra("units") as ArrayList<String>
        category = intent.getStringExtra("name").toString()

        // set data at spinner
        fromSplinner.adapter =ArrayAdapter(applicationContext, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,unit)
        toSplinner.adapter =ArrayAdapter(applicationContext, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,unit)


        // close activity

        backBtn.setOnClickListener(View.OnClickListener {
            this.finish()
        })


        // add a from value selector listener

      fromSplinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
          override fun onItemSelected(
              parent: AdapterView<*>?,
              view: View?,
              position: Int,
              id: Long
          ) {
              fromUnit = unit[position].toString()
              if(fromInputEditText.text.toString()!=""){
                  Log.d("Data:", "$ from unit : {fromUnit}")
                  toInputEditText.setText(getCalulation().toString())
                  Log.d("Data", "Input number ${fromInputEditText.text} ")
//                  Log.d("Data", "${toInputEditText}")
              }
          }

          override fun onNothingSelected(parent: AdapterView<*>?) {
              fromUnit = unit[0].toString()
          }
      }

        // add to value spinner value selection listener

        toSplinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                toUnit = unit[position].toString()
                Log.d("data", "toUnit : ${toUnit} ")
                if(fromInputEditText.text.toString()!=""){
                    Log.d("Data:", toUnit)
                    toInputEditText.setText(getCalulation().toString())
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                toUnit = unit[0].toString()
            }
        }


        // Apply Change event of edit text

        fromInputEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                toInputEditText.setText("0.0")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
              if(fromInputEditText.text.toString().isNotEmpty()){
                  toInputEditText.setText(getCalulation().toString())
              }
            }

            override fun afterTextChanged(p0: Editable?) {
                if(fromInputEditText.text.toString().isNotEmpty()){
                    toInputEditText.setText(getCalulation().toString())
                }
            }

        })

    }

    // function for return calculation outcome

    fun getCalulation():Double{
        when (category){
            "Speed"->{
                return Common.Speed().calculation(from = fromUnit,to =  toUnit, number = fromInputEditText.text.toString().toDouble())

            }
            "Area"->{
                return Common.Area().calculation(from = fromUnit,to =  toUnit, number = fromInputEditText.text.toString().toDouble())
            }
            "Temperature"->{
                return Common.Temperature().calculation(from = fromUnit,to =  toUnit, number = fromInputEditText.text.toString().toDouble())
            }

            else->
                return 0.0
        }
    }
}

