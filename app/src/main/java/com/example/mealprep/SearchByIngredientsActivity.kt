package com.example.mealprep

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SearchByIngredientsActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_by_ingredient_activity)

        val db = Room.databaseBuilder(this, AppDatabase::class.java, "mydatabase")
            .allowMainThreadQueries().build()
        val mealDao = db.MealDao()
        val btnSearchIngr = findViewById<Button>(R.id.btnSearchByIngr)



//        val display = findViewById<TextView>(R.id.outputAPI)
//        btnSearchIngr.setOnClickListener{
//            val txtInput = findViewById<TextView>(R.id.txtIngredient)
//            val searchString = txtInput.text.toString()
//            // collecting all the JSON string
//            val stb = StringBuilder()
//            txtInput.clearFocus()
//
//            val urlStr = URL("https://www.themealdb.com/api/json/v1/1/filter.php?i=${searchString}")
//            val con: HttpURLConnection = urlStr.openConnection() as HttpURLConnection
//
//            runBlocking {
//                launch {
//                    // run the code of the coroutine in a new thread
//                    withContext(Dispatchers.IO) {
//                        val br = BufferedReader(InputStreamReader(con.inputStream))
//                        var newline = br.readLine()
//                        while (newline != null) {
//                            stb.append(newline)
//                            newline = br.readLine()
//                        }
//                        br.close()
//                        con.disconnect()
//                    }
//                }
//
//                val jsonobj = JSONObject(stb.toString())
//                val jsonArr = jsonobj.getJSONArray("meals")

//                println("$stb")
//                display.text = "$stb"
//            }
//        }
    }
}