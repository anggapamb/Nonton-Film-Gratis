package com.anggapambudi.nontonfilmgratis.response

import com.google.gson.annotations.SerializedName

data class ItemFilmResponse(

	@field:SerializedName("result")
	val result: ArrayList<ResultItem>? = null,

	@field:SerializedName("page")
	val page: Int? = null
)

data class ResultItem(

	@field:SerializedName("duration")
	val duration: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("watch")
	val watch: String? = null,

	@field:SerializedName("genre")
	val genre: List<String?>? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("quality")
	val quality: String? = null,

	@field:SerializedName("trailer")
	val trailer: String? = null
)
