package com.example.mealprep

import androidx.room.*


@Dao
interface MealDao {
    @Query("select * from meal")
    suspend fun getAll(): List<Meal>

    @Query("SELECT * FROM meal WHERE strMeal LIKE '%' || :searchString || '%' OR strIngredient1 LIKE '%' || :searchString || '%' OR strIngredient2 LIKE '%' || :searchString || '%' OR strIngredient3 LIKE '%' || :searchString || '%' OR strIngredient4 LIKE '%' || :searchString || '%'")
    fun searchMeals(searchString: String): List<Meal>

    @Query("" +
            "select * from meal " +
            "where lower(strMeal) like '%'||:searchString||'%'" +
            "or lower(strIngredient1) like '%'||:searchString||'%'" +
            "or lower(strIngredient2) like '%'||:searchString||'%'" +
            "or lower(strIngredient3) like '%'||:searchString||'%'" +
            "or lower(strIngredient4) like '%'||:searchString||'%'" +
            "or lower(strIngredient5) like '%'||:searchString||'%'" +
            "or lower(strIngredient6) like '%'||:searchString||'%'" +
            "or lower(strIngredient7) like '%'||:searchString||'%'" +
            "or lower(strIngredient8) like '%'||:searchString||'%'" +
            "or lower(strIngredient9) like '%'||:searchString||'%'" +
            "or lower(strIngredient10) like '%'||:searchString||'%'")
    suspend fun getUserSearchedMeals(searchString: String?): List<Meal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeals(vararg meal: Meal)
}