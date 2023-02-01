package com.example.hw3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Book (
    @StringRes val stringTitle: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val stringAuthor: Int,
    @StringRes val stringPublisher: Int,
    @StringRes val stringYear: Int,
    @StringRes val stringVersion: Int,
    @StringRes val stringSummary: Int
    ) {

}