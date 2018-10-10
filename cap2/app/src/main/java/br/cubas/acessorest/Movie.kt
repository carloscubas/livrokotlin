package br.cubas.acessorest

import com.beust.klaxon.Json

class Movie(@Json(name = "Title") val title: String = "",
            @Json(name = "Year") val year: String = "",
            @Json(name = "Type") val type: String = "",
            @Json(name = "Poster") val poster: String = "")
