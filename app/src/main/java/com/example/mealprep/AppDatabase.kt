package com.example.mealprep

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Meal :: class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun MealDao(): MealDao

//    object DatabaseSingleton {
//        private var database: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            if (database == null) {
//                database = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "my-app-database"
//                ).build()
//            }
//            return database!!
//        }
//    }
}