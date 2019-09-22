package com.example.udemymvvm.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.udemymvvm.model.Category

@Dao
interface CategoryDao {

    @Insert
    fun insert(category: Category)

    @Update
    fun update(category: Category)

    @Delete
    fun delete(category: Category)

    @Query("SELECT * FROM categories_table")
    fun getAllCategories(): LiveData<List<Category>>
}