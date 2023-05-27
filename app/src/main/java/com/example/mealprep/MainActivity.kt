package com.example.mealprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddToDb = findViewById<Button>(R.id.add_meals_button)
        val btnSearchByIngredient = findViewById<Button>(R.id.search_by_ingredient_button)
        val btnSearchMeal = findViewById<Button>(R.id.search_meals_button)

        val db = Room.databaseBuilder(this, AppDatabase::class.java,"mydatabase").allowMainThreadQueries().build()
        //db = AppDatabase.DatabaseSingleton.getDatabase(applicationContext)
        val mealDao = db.MealDao()


        //populating database
        btnAddToDb.setOnClickListener{
            runBlocking {
                launch {
                    val meal = Meal(
                        1,
                        "Sweet and Sour Pork",
                        "https://www.themealdb.com/images/media/meals/1529442316.jpg",
                        "Pork",
                        "Egg",
                        "Water",
                        "Salt",
                        "Sugar",
                        "Soy Sauce",
                        "Starch",
                        "Tomato Puree",
                        "Vinegar",
                        "Coriander"
                    )
                    val meal2 = Meal(
                        2,
                        "Chicken Marengo",
                        "https://www.themealdb.com/images/media/meals/qpxvuq1511798906.jpg",
                        "Olive Oil",
                        "Mushrooms",
                        "Chicken Legs",
                        "Passata",
                        "Chicken Stock Cube",
                        "Black Olives",
                        "Parsley",
                        "",
                        "",
                        ""
                    )
                    val meal3 = Meal(
                        3,
                        "Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber",
                        "https://www.themealdb.com/images/media/meals/z0ageb1583189517.jpg",
                        "Rice",
                        "Onion",
                        "Lime",
                        "Garlic Clove",
                        "Cucumber",
                        "Carrots",
                        "Ground Beef",
                        "Soy Sauce",
                        "",
                        ""
                    )
                    val meal4 = Meal(
                        4,
                        "Leblebi Soup",
                        "https://www.themealdb.com/images/media/meals/x2fw9e1560460636.jpg",
                        "Olive Oil",
                        "Onion",
                        "Chickpeas",
                        "Vegetable Stock",
                        "Cumin",
                        "Garlic",
                        "Salt",
                        "Harissa Spice",
                        "Pepper",
                        "Lime"
                    )
                    mealDao.insertMeals(meal)
                    mealDao.insertMeals(meal2)
                    mealDao.insertMeals(meal3)
                    mealDao.insertMeals(meal4)
                    Toast.makeText(applicationContext,"Successfully added",Toast.LENGTH_SHORT).show()
                    //debug
//                    println("$meal")
//                    println("$meal3")
//                    val meals: List<Meal> = mealDao.getAll()
//                    val output = java.lang.StringBuilder()
//                    output.append(meals[0]).toString()
//                    println("$output")
//                    print(meals)
//                    print(output)
                }
            }

        }

        //main page button functions
        btnSearchMeal.setOnClickListener{
            val intent = Intent(this, SearchMealsInDbActivity::class.java)
            startActivity(intent)
        }

        btnSearchByIngredient.setOnClickListener{
            val intent = Intent(this, SearchByIngredientsActivity::class.java)
            startActivity(intent)
        }
    }
}