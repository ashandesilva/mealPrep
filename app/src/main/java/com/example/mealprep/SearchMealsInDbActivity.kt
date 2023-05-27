package com.example.mealprep

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.w3c.dom.Text

class SearchMealsInDbActivity: AppCompatActivity() {
    private var saveOutput = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_meals_in_db_activity)
        //accessing db
        val db = Room.databaseBuilder(this, AppDatabase::class.java,"mydatabase").allowMainThreadQueries().build()
        //db = AppDatabase.DatabaseSingleton.getDatabase(applicationContext)
        val mealDao = db.MealDao()
        val btnSearchMeal = findViewById<Button>(R.id.btnSearchMeals)

        val display = findViewById<TextView>(R.id.output)
        btnSearchMeal.setOnClickListener{
            val txtInput = findViewById<TextView>(R.id.txtMeal)
            val searchString = txtInput.text.toString()

            if (searchString.trim() != ""){
                val output = java.lang.StringBuilder()
                txtInput.clearFocus()
                runBlocking {
                    launch {
                        val meals: List<Meal> = mealDao.getUserSearchedMeals(searchString)
                        for (i in meals){
                            output.append("Meal Name: ${i.strMeal}, Ingredients: ${i.strIngredient1},${i.strIngredient2},${i.strIngredient3},${i.strIngredient4}\n")
                        }
                    }
                }
                println("$output")
                //display retrived data to user
                display.text = "$output"
            }
            else{
                Toast.makeText(applicationContext,"Enter a valid value", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("SAVE_DATE", saveOutput)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        saveOutput = savedInstanceState.getString("SAVE_DATE").toString()
    }
}