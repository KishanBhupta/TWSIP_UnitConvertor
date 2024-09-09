package com.example.unit_calculation.supportclass

import android.util.Log
import kotlin.math.log

class Common {

    //todo :  Speed

    class Speed{
        private var unit:ArrayList<String> = ArrayList();
        init {
            unit = arrayListOf(
                "Mile Per Hour",
                "Foot Per Second",
                "Meter Per Second",
            )
        }

        fun getUnit():ArrayList<String>{
            return this.unit
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


    // todo : Area

    class Area{
        private var unit:ArrayList<String> = ArrayList();
        init {
            unit = arrayListOf(
                "Square Kilometer",
                "Square Meter",
                "Square Mile",
                "Square Yard",
                "Square Foot",
                "Square Inch",
            )
        }

        fun getUnit():ArrayList<String>{
            return this.unit
        }

        fun calculation(from:String?= null , to:String?= null , number:Double = 0.0  ):Double {
            Log.d("calculation", "calculation from : ${from} ")
            Log.d("calculation", "calculation to : ${to} ")
            Log.d("calculation", "calculation number : ${number} ")
            if (from.equals(to)) {
                return number
            }
            when (from) {
                "Square Kilometer" -> return when (to) {
                    "Square Meter" -> number * 1e+6
                    "Square Mile" -> number / 2.59
                    "Square Yard" -> number * 1.196e+6
                    "Square Foot" -> number * 1.076e+7
                    "Square Inch" -> number * 1.55e+9
                    "Hectare" -> number * 100
                    "Acre" -> number * 247.1
                    else -> 0.0
                }

                "Square Meter" -> return when (to) {
                    "Square Kilometer" -> number / 1e+6
                    "Square Mile" -> number / 2.59e+6
                    "Square Yard" -> number * 1.196
                    "Square Foot" -> number * 10.764
                    "Square Inch" -> number * 1550

                    else -> 0.0
                }

                "Square Mile" -> return when (to) {
                    "Square Kilometer" -> number * 2.59
                    "Square Meter" -> number * 2.59e+6
                    "Square Yard" -> number * 3.098e+6
                    "Square Foot" -> number * 2.788e+7
                    "Square Inch" -> number * 4.014e+9

                    else -> 0.0
                }

                "Square Yard" -> return when (to) {
                    "Square Kilometer" -> number / 1.196e+6
                    "Square Meter" -> number / 1.196
                    "Square Mile" -> number / 3.098e+6
                    "Square Foot" -> number * 9
                    "Square Inch" -> number * 1296
                    else -> 0.0
                }

                "Square Foot" -> return when (to) {
                    "Square Kilometer" -> number / 1.076e+7
                    "Square Meter" -> number / 10.764
                    "Square Mile" -> number / 2.788e+7
                    "Square Yard" -> number / 9
                    "Square Inch" -> number * 144

                    else -> 0.0
                }

                "Square Inch" -> return when (to) {
                    "Square Kilometer" -> number / 1.55e+9
                    "Square Meter" -> number / 1550
                    "Square Mile" -> number / 4.014e+9
                    "Square Yard" -> number / 1296
                    "Square Foot" -> number / 144

                    else -> 0.0
                }

                else ->return 0.0
            }
        }
    }

    // todo : Frequency
    class Frequency{
        private var unit:ArrayList<String> = ArrayList();
        init {
            unit = arrayListOf(
                "Mile Per Hour",
                "Foot Per Second",
                "Meter Per Second",
            )
        }

        fun getUnit():ArrayList<String>{
            return this.unit
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

    // todo : Temperature
    class Temperature{
        private var unit:ArrayList<String> = ArrayList();
        init {
            unit = arrayListOf(
                "Degree Celsius",
                "Fahrenheit",
                "Kelvin"
            )
        }

        fun getUnit():ArrayList<String>{
            return this.unit
        }

        fun calculation(from:String?= null , to:String?= null , number:Double = 0.0  ):Double {
            Log.d("calculation", "calculation from : ${from} ")
            Log.d("calculation", "calculation to : ${to} ")
            Log.d("calculation", "calculation number : ${number} ")
            if (from.equals(to)) {
                return number
            }
            when (from) {
                "Degree Celsius" -> return when (to) {
                    "Fahrenheit" -> (number * 9 / 5) + 32
                    "Kelvin" -> number + 273.15
                    else -> 0.0
                }

                "Fahrenheit" -> return when (to) {
                    "Degree Celsius" -> (number - 32) * (5 / 9)
                    "Kelvin" -> (number - 32) * (5 / 9) + 273.15
                    else -> 0.0
                }

                "Kelvin" -> return when (to) {
                    "Degree Celsius" -> number - 273.15
                    "Fahrenheit" -> (number - 273.15) * (9 / 5) + 32
                    else -> 0.0
                }

                else ->return 0.0
            }
        }
    }

    class Mass {
        private var units: ArrayList<String> = ArrayList()

        init {
            units = arrayListOf(
                "Tonne",
                "Kilogram",
                "Gram",
                "Milligram",
                "Microgram",
                "Pound",
            )
        }

        fun getUnits(): ArrayList<String> {
            return this.units
        }

        fun calculate(from: String? = null, to: String? = null, number: Double = 0.0): Double {
            if (from.equals(to)) {
                return number
            }
            when (from) {
                "Tonne" -> return when (to) {
                    "Kilogram" -> number * 1000
                    "Gram" -> number * 1e+6
                    "Milligram" -> number * 1e+9
                    "Microgram" -> number * 1e+12
                    "Pound" -> number * 2205
                    else -> 0.0
                }

                "Kilogram" -> return when (to) {
                    "Tonne" -> number / 1000
                    "Gram" -> number * 1000
                    "Milligram" -> number * 1e+6
                    "Microgram" -> number * 1e+9
                    "Pound" -> number * 2.205
                    else -> 0.0
                }

                "Gram" -> return when (to) {
                    "Tonne" -> number / 1e+6
                    "Kilogram" -> number / 1000
                    "Milligram" -> number * 1000
                    "Microgram" -> number * 1e+6
                    "Pound" -> number / 453.6
                    else -> 0.0
                }

                "Milligram" -> return when (to) {
                    "Tonne" -> number / 1e+9
                    "Kilogram" -> number / 1e+6
                    "Gram" -> number / 1000
                    "Microgram" -> number * 1000
                    "Pound" -> number / 453600
                    else -> 0.0
                }

                "Microgram" -> return when (to) {
                    "Tonne" -> number / 1e+12
                    "Kilogram" -> number / 1e+9
                    "Gram" -> number / 1e+6
                    "Milligram" -> number / 1000
                    "Pound" -> number / 4.536e+8
                    else -> 0.0
                }

                "Pound" -> return when (to) {
                    "Tonne" -> number / 2205
                    "Kilogram" -> number / 2.205
                    "Gram" -> number * 453.6
                    "Milligram" -> number * 453600
                    "Microgram" -> number * 4.536e+8
                    else -> 0.0
                }

                else -> return 0.0
            }
        }
    }
}