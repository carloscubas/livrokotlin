package br.cubas.acessorest.api

import br.cubas.acessorest.utils.Constants.URL_SERVIDOR
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getClient(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(URL_SERVIDOR)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}