package br.cubas.acessorest.utils

import br.cubas.acessorest.models.Movie
import br.cubas.acessorest.models.MovieData
import com.beust.klaxon.Klaxon
import org.json.JSONException
import java.net.URL
import java.util.*

object Util {

    fun parse(path: String?): List<Movie>?{
        val contents = URL(path).readText()
        val movieData = contents?.let { Klaxon().parse<MovieData>(it) }
        return movieData?.Search
    }

}