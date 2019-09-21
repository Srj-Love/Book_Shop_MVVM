package com.example.udemymvvm

import com.example.udemymvvm.dao.BookDao
import com.example.udemymvvm.dao.CategoryDao
import com.example.udemymvvm.model.Book
import com.example.udemymvvm.model.Category

class Common {

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "SrjBookDB"

        fun getAllBooks(bookDao: BookDao) = listOf(
            Book(_bookName = "High school Java ", _unitPrice = "$150", _categoryId = 1),
            Book(_bookName = "Mathematics for beginners", _unitPrice = "$200", _categoryId = 1),
            Book(
                _bookName = "Object Oriented Androd App Design ",
                _unitPrice = "$150",
                _categoryId = 1
            ),
            Book(_bookName = "Astrology for beginners ", _unitPrice = "$150", _categoryId = 1),
            Book(_bookName = "High school Magic Tricks ", _unitPrice = "$150", _categoryId = 1),
            Book(
                _bookName = "Chemistry  for secondary school students ",
                _unitPrice = "$250",
                _categoryId = 1
            ),
            Book(_bookName = "A Game of Cats ", _unitPrice = "$19.99", _categoryId = 2),
            Book(_bookName = "The Hound of the New York ", _unitPrice = "$16.99", _categoryId = 2),
            Book(_bookName = "Adventures of Joe Finn ", _unitPrice = "$13", _categoryId = 2),
            Book(_bookName = "Arc of witches ", _unitPrice = "$19.99", _categoryId = 2),
            Book(_bookName = "Can I run ", _unitPrice = "$16.99", _categoryId = 2),
            Book(_bookName = "Story of a joker ", _unitPrice = "$13", _categoryId = 2)
        ).forEach {
            bookDao.insert(it)
        }


        fun getAllCategories(categoryDao: CategoryDao) = listOf(
            Category (_categoryName = "Text Books", _categoryDescription = "Text Books Description"),
            Category (_categoryName = "Novels", _categoryDescription = "Novels Description"),
            Category (_categoryName = "Other Books", _categoryDescription = "Text Books Description")
        ).forEach {
            categoryDao.insert(it)
        }


    }


    /*  val book13 = Book()
      book13.setBookName("Notes of a alien life cycle researcher")
      book13.unitPrice = ("$1250")
      book13.setCategoryId(3)

      val book14 = Book()
      book14.setBookName("Top 9 myths abut UFOs")
      book14.unitPrice = ("$789")
      book14.setCategoryId(3)

      val book15 = Book()
      book15.setBookName("How to become a millionaire in 24 hours")
      book15.unitPrice = ("$1250")
      book15.setCategoryId(3)

      val book16 = Book()
      book16.setBookName("1 hour work month")
      book16.unitPrice = "$199"
      book16.categoryId(3)*/
}