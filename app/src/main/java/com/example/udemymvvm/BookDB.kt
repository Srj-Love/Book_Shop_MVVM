package com.example.udemymvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.udemymvvm.Common.Companion.DB_NAME
import com.example.udemymvvm.Common.Companion.DB_VERSION
import com.example.udemymvvm.dao.BookDao
import com.example.udemymvvm.dao.CategoryDao
import com.example.udemymvvm.model.Book
import com.example.udemymvvm.model.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(version = DB_VERSION, entities = arrayOf(Category::class, Book::class))
abstract class BookDB : RoomDatabase() {


    // get  the interfaces of respected entity (Tables)

    abstract fun categoryDao(): CategoryDao
    abstract fun bookDao(): BookDao


    companion object {

        @Volatile
        private var instance: BookDB? = null
        private val LOCK = Any()


        /*
               operator fun invoke(context: Context): BookDB {
            val instance1 = instance
            return if (instance1 != null) instance1 else synchronized<BookDB>(LOCK) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }
         */

        // above commented () are for detailed view of this Funtion
        operator fun invoke(context: Context, scope: CoroutineScope) =
            instance ?: synchronized(LOCK) {
                instance ?: buildDatabase(context, scope).also { instance = it }
            }


        private fun buildDatabase(context: Context, scope: CoroutineScope) = Room.databaseBuilder(
            context, BookDB::class.java,
            DB_NAME
        )
            .fallbackToDestructiveMigrationFrom() // when we are changing the db_version , it will delete the data and recreates the tables
            .addCallback(BookDbCallback(scope))
            .build()

    }


    // create callback forr room to execute query in bg\
    private class BookDbCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            instance?.let {
                scope.launch {

                    Common.getAllCategories(it.categoryDao())
                    Common.getAllBooks(it.bookDao())


                }
            }
        }
    }


}