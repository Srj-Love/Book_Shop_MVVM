package com.example.udemymvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.udemymvvm.model.Book
import com.example.udemymvvm.model.Category
import com.example.udemymvvm.repository.EBookRepository

class ShopActivityViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var eBookRepository: EBookRepository

    init {
        eBookRepository = EBookRepository(application)
    }


    private var allCategory: LiveData<List<Category>>? = null
        get() {
            allCategory = eBookRepository.categories
            return field
        }

    private var selectedBook: LiveData<List<Book>>? = null


    fun getSelectedBook(id: Int): LiveData<List<Book>>? {

        selectedBook = eBookRepository.getBooks(id)
        return selectedBook
    }


    //================= Book CRUD ===============
    fun addNewBook(book: Book) {
        eBookRepository.insertBook(book)
    }

    fun updateBook(book: Book) {
        eBookRepository.updateBook(book)
    }

    fun deleteBook(book: Book) {
        eBookRepository.deleteBook(book)
    }

    //================= Category CRUD ===============
    fun addNewCategory(category: Category) {
        eBookRepository.insertCategory(category)
    }

    fun updateCategory(category: Category) {
        eBookRepository.updateCategory(category)
    }

    fun deleteCategory(category: Category) {
        eBookRepository.deleteCategory(category)
    }


}