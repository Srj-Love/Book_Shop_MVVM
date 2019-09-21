package com.example.udemymvvm.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Entity(tableName = "categories_table") :- Used for Table for Room
 * @ColumnInfo(name = "category_name") :- Used for defining Coloumn names
 * @PrimaryKey(autoGenerate = true) :- Is used to tell room that it's a Primary Key
 */
@Entity(tableName = "categories_table")
class Category(

    @ColumnInfo(name = "category_name")
    private var _categoryName: String,
    @ColumnInfo(name = "category_desc")
    private var _categoryDescription: String
) : BaseObservable() {

    @PrimaryKey(autoGenerate = true)
    private var _id: Int = 0

    /**
     * Here we are creating a getter/ Setter which helps to Observe the data with the help of
     * @Bindable tag and,
     * Using notifyPropertyChanged() we are binding the data with Views eg. BR.id
     */
    var id: Int
        @Bindable get() = _id
        set(value) {
            _id = value
            notifyPropertyChanged(androidx.databinding.library.baseAdapters.BR.id)
        }


    var categoryName: String
        @Bindable get() = categoryName
        set(value) {
            categoryName = value
            notifyPropertyChanged(androidx.databinding.library.baseAdapters.BR.categoryName)
        }


    var categoryDescription: String
        @Bindable get() = categoryDescription
        set(value) {
            categoryDescription = value
            notifyPropertyChanged(androidx.databinding.library.baseAdapters.BR.categoryDescription)
        }
}