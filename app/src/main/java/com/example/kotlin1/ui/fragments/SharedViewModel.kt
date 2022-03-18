package com.example.kotlin1.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1.ui.client.BooksClient
import com.example.kotlin1.ui.model.BookModel


class SharedViewModel : ViewModel() {
    val description = MutableLiveData<String>()


    fun getBooks(): List<BookModel> {
        return BooksClient().getBooks()
    }

    fun putDescription(text: String) {
        description.value = text
    }


}