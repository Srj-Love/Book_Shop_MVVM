package com.example.udemymvvm.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.udemymvvm.BookDB
import com.example.udemymvvm.dao.BookDao
import com.example.udemymvvm.dao.CategoryDao
import com.example.udemymvvm.model.Book
import com.example.udemymvvm.model.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class EBookRepository(application: Application) {

    private var categoryDao: CategoryDao? = null
    private var bookDao: BookDao? = null

    private val categories: LiveData<List<Category>>?
        get() = categoryDao?.getAllCategories()

    private var books: LiveData<List<Book>>? = null


    init {
        val bookDB = BookDB.invoke(application, CoroutineScope(Dispatchers.IO))
        categoryDao = bookDB.categoryDao()
        bookDao = bookDB.bookDao()
    }


    fun getBooks(id: Int): LiveData<List<Book>>? {
        return bookDao?.getBook(id)
    }

    /* TODO: check if insertCategory, insertBook, deleteBook, deleteCategory,
        updateBook and updateCategoryare running in Main or IO threads*/

    fun insertCategory(category: Category) {
        categoryDao?.insert(category = category)
    }

    fun insertBook(book: Book) {
        bookDao?.insert(book = book)
    }

    fun deleteBook(book: Book) {
        bookDao?.delete(book = book)
    }

    fun deleteCategory(category: Category) {
        categoryDao?.delete(category = category)
    }

    fun updateBook(book: Book) {
        bookDao?.update(book = book)
    }

    fun updateCategory(category: Category) {
        categoryDao?.update(category = category)
    }


    // get All categories

}