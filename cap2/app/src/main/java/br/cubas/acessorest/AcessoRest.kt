package br.cubas.acessorest

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log

import kotlinx.android.synthetic.main.activity_acesso_rest.*

class AcessoRest : AppCompatActivity() {

    var listMovies : List<Movie>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acesso_rest)

        var recyclerView = movie_list_recyclerview
        recyclerView.adapter = MovieListAdapter(listMovies, this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        AcessoRest.LensoServidor().start()
    }

    class LensoServidor() : Thread() {
        override fun run() {
            val url = Uri.parse(Constants.URLSERVIDOR).toString()
            val contents = Util.acessar(url)
            //listMovies = Util.movieConverter(contents)
        }
    }

    private fun movies(): List<Movie> {
        return listOf(
            Movie("Era uma vez no Oeste",
                    "2012", "movie", "sem poster"),
            Movie("Onde os Fracos Não Tem Vez ",
                    "2013", "movie", "sem poster"),
            Movie("The Rocky Horror Picture Show",
                    "2014", "movie", "sem poster"))
    }
}