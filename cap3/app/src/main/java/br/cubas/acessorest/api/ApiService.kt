package br.cubas.acessorest.api

import br.cubas.acessorest.models.MovieData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("/?r=json")
    fun findMovies(@Query("apiKey") apiKey: String,
                   @Query("type") type: String,
                   @Query("s") country: String,
                   @Query("page") page: Int,
                   @Header("Content-Type") content_type: String): Call<MovieData>
}