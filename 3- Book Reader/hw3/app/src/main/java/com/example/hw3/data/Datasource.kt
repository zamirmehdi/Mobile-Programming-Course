package com.example.hw3.data

import com.example.hw3.R
import com.example.hw3.model.Book

class Datasource {

    fun loadBooks(): List<Book> {
        return listOf<Book>(
            Book(R.string.title1, R.drawable.the_zahir__novel_, R.string.author1, R.string.pub1, R.string.year1, R.string.version1, R.string.summary1),
            Book(R.string.title2, R.drawable.thealchemist, R.string.author2, R.string.pub2, R.string.year2, R.string.version2, R.string.summary2),
            Book(R.string.title3, R.drawable.deepwork, R.string.author3, R.string.pub3, R.string.year3, R.string.version3, R.string.summary3),
            Book(R.string.title4, R.drawable.parallel_worlds_kaku_2004, R.string.author4, R.string.pub4, R.string.year4, R.string.version4, R.string.summary4),
            Book(R.string.title5, R.drawable.no_excuses_, R.string.author5, R.string.pub5, R.string.year5, R.string.version5, R.string.summary5)
        )
    }
}