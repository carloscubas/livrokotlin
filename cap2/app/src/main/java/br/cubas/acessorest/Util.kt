package br.cubas.acessorest

import android.util.Log
import com.beust.klaxon.Klaxon
import java.net.URL
import java.util.*
import org.json.JSONException

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
        return movieData?.search
    }

}