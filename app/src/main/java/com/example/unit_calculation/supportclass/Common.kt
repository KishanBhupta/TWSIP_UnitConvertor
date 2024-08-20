package com.example.unit_calculation.supportclass

import android.util.Log
import kotlin.math.log

class Common {
    class Speed{
        private var spped:ArrayList<String> = ArrayList();
        init {
            spped = arrayListOf(
                "Mile Per Hour",
                "Foot Per Second",
                "Meter Per Second",
            )
        }

        fun getUnit():ArrayList<String>{
            return this.spped
        }

        fun calculation(from:String?= null , to:String?= null , number:Double = 0.0  ):Double {
            Log.d("calculation", "calculation from : ${from} ")
            Log.d("calculation", "calculation to : ${to} ")
            Log.d("calculation", "calculation number : ${number} ")
            if (from.equals(to)) {
                return number
            }
            when (from) {
                "Mile Per Hour" -> return when (to) {
                    "Foot Per Second" -> number * 1.467
                    "Meter Per Second" -> number / 2.237
                    else -> 0.0
                }

                "Foot Per Second" -> return when (to) {
                    "Mile Per Hour" -> number / 1.467
                    "Meter Per Second" -> number / 3.281
                    else -> 0.0
                }

                "Meter Per Second" -> return when (to) {
                    "Mile Per Hour" -> number * 2.237
                    "Foot Per Second" -> number * 3.281
                    else -> 0.0
                }


                else ->return 0.0
            }
        }
    }
}