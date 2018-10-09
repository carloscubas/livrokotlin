package br.cubas.acessorest

import android.net.Uri
import android.util.Log

class LensoServidor : Thread() {

    val URLSERVIDOR = "http://www.omdbapi.com/?apikey=ed5a2df5&type=movie&r=json&s=brazil&page=1"

    override fun run() {
        val url = Uri.parse(URLSERVIDOR).toString()
        val conteudo = Util.acessar(url)
        Log.i("aula", conteudo)
    }

}