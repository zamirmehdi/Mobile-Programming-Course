package com.example.hw3

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class BookInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_info)

        val actionBar = supportActionBar

        var bookId = intent?.extras?.getInt("book_id")
        if (bookId != null) {
            bookId += 1
        }
        actionBar!!.title = "Full Details of the Book $bookId"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val title = intent?.extras?.getString("title").toString()
        val author = intent?.extras?.getString("author").toString()
        val publisher = intent?.extras?.getString("publisher").toString()
        val year = intent?.extras?.getString("year").toString()
        val version = intent?.extras?.getString("version").toString()
        val summary = intent?.extras?.getString("summary").toString()
        val image = intent?.extras?.getInt("image")

        actionBar!!.title = "$title"

        val bookTitle: TextView = findViewById<TextView>(R.id.book_title)
        val bookAuthor: TextView = findViewById<TextView>(R.id.book_author)
        val bookPublisher: TextView = findViewById<TextView>(R.id.book_publisher)
        val bookYear: TextView = findViewById<TextView>(R.id.book_year)
        val bookVersion: TextView = findViewById<TextView>(R.id.book_version)
        val bookSummary: TextView = findViewById<TextView>(R.id.book_summary)
        val bookImage: ImageView = findViewById<ImageView>(R.id.book_image)

        if (image != null) {
            bookImage.setImageResource(image)
        }
        bookTitle.text = "Title: " + title
        bookAuthor.text = "Author:                                " + author
        bookPublisher.text = "Publisher:                           " + publisher
        bookYear.text = "Publication year:               " + year
        bookVersion.text = "Version:                              " + version
        bookSummary.text = "Summary: \n" + summary

    }
}