package com.example.udemymvvm.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

/**
 * @Entity(tableName = "book_table") :- Used for Table for Room
 * @ColumnInfo(name = "category_name") :- Used for defining Coloumn names
 * @PrimaryKey(autoGenerate = true) :- Is used to tell room that it's a Primary Key
 *
 * @ForeignKey :- one to many Relationship :- one book can have many categories. {@link #onDelete = CASCADE}
 * means if categories  are deleted, we would like to delted Book also.
 *
 */
@Entity(
    tableName = "book_table",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Category::class,
            parentColumns = arrayOf("_id"),
            childColumns = arrayOf("category_id"),
            onDelete = CASCADE
        )
    )
)
class Book(

    @ColumnInfo(name = "book_name")
    private var _bookName: String,
    @ColumnInfo(name = "unit_price")
    private var _unitPrice: String,
    @ColumnInfo(name = "category_id")
    private var _categoryId: Int
) : BaseObservable() {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_Id")
    private var _bookId: Int = 0

    /**
     * Here we are creating a getter/ Setter which helps to Observe the data with the help of
     * @Bindable tag and,
     * Using notifyPropertyChanged() we are binding the data with Views eg. BR.id
     */
    var bookId: Int
        @Bindable get() = bookId
        set(value) {
            bookId = value
            notifyPropertyChanged(androidx.databinding.library.baseAdapters.BR.bookId)
        }


    var bookName: String
        @Bindable get() = bookName
        set(value) {
            bookName = value
            notifyPropertyChanged(androidx.databinding.library.baseAdapters.BR.bookName)
        }

    var unitPrice: String
        @Bindable get() = unitPrice
        set(value) {
            unitPrice = value
            notifyPropertyChanged(androidx.databinding.library.baseAdapters.BR.unitPrice)
        }


    var categoryId: String
        @Bindable get() = categoryId
        set(value) {
            categoryId = value
            notifyPropertyChanged(androidx.databinding.library.baseAdapters.BR.categoryId)
        }
}