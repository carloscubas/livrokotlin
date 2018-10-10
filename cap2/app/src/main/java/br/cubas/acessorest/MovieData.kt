package br.cubas.acessorest

import com.beust.klaxon.Json

data class MovieData(@Json(name = "totalResults") val totalResults: String = "",
                     @Json(name = "Response") val response: String = "True",
                     @Json(name = "Search") val search: List<Movie>? = null )

