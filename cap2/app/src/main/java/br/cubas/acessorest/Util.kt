package br.cubas.acessorest

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

}