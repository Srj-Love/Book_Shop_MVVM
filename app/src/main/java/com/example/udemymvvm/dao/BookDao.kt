package com.example.udemymvvm.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.udemymvvm.model.Book

@Dao
interface BookDao {

    @Insert
    fun insert(book: Book)

    @Update
    fun update(book: Book)

    @Delete
    fun delete(book: Book)

    @Query("SELECT * FROM book_table")
    fun getAllBooks(): LiveData<List<Book>>

    // category_id==:categoryId :-- Use : to  mention parameter data
    @Query("SELECT * FROM book_table WHERE category_id==:categoryId")
    fun getBook(categoryId: Int): LiveData<List<Book>>
}