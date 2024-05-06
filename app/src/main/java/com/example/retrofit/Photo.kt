package com.example.retrofit

import android.provider.ContactsContract.Data

data class Photo(

	val id: Int,
	val price: Double,
	val title: String,
	val image: String,
	val description: String,
	val category: String,
	val rating: Rating

)
