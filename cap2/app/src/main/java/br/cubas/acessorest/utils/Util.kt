package br.cubas.acessorest.utils

import br.cubas.acessorest.models.Movie
import com.beust.klaxon.Klaxon
import org.json.JSONException

object Util {
    @Throws(JSONException::class)
    fun movieConverter(contents: String?): List<Movie>? {
        val movies = contents?.let { Klaxon().parse<List<Movie>>(it) }
        return movies
    }
}