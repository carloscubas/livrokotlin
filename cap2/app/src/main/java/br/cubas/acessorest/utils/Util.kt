package br.cubas.acessorest.utils

import br.cubas.acessorest.models.Movie
import br.cubas.acessorest.models.MovieData
import com.beust.klaxon.Klaxon
import org.json.JSONException
import java.net.URL
import java.util.*

object Util {

    fun acessar(endereco: String): String? {
            val url = URL(endereco)
            val conn = url.openConnection()
            val `is` = conn.getInputStream()
            val scanner = Scanner(`is`)
            val conteudo = scanner.useDelimiter("\\A").next()
            scanner.close()
            return conteudo
    }

    @Throws(JSONException::class)
    fun movieConverter(contents: String?): List<Movie>? {
        val movieData = contents?.let { Klaxon().parse<MovieData>(it) }
        return movieData?.Search
    }

}