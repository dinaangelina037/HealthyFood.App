package com.dina.resepmakanan.model.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseKategori(

	@field:SerializedName("data")
	val data: List<Kategori?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)