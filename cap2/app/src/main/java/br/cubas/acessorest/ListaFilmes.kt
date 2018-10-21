package br.cubas.acessorest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import br.cubas.acessorest.models.Movie
import kotlinx.android.synthetic.main.activity_acesso_rest.*

class ListaFilmes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acesso_rest)

        var recyclerView = movie_list_recyclerview
        //val layoutManager = LinearLayoutManager(this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = MovieListAdapter(listaFilmes(), this)
    }

    private fun listaFilmes() : List<Movie>{
        val movies: ArrayList<Movie> = ArrayList()
        movies.add(Movie("Viagem à Lua", "1902", "Ficção", R.drawable.viagem_a_lua))
        movies.add(Movie("2001 – Uma Odisseia no Espaço", "2001", "Ficção", R.drawable.uma_odiseia_no_espaco))
        movies.add(Movie("Blade Runner", "1982", "Ficção", R.drawable.blade_runner))
        movies.add(Movie("Jogos de Guerra", "1983", "Ficção", R.drawable.jogos_guerra))
        movies.add(Movie("Hackers", "1995", "Ficção", R.drawable.hackers))
        movies.add(Movie("Tron", "1982", "Ficção", R.drawable.tron))
        movies.add(Movie("Piratas do Vale do Silício", "1999", "Ficção", R.drawable.piratas_vale_silicio))
        return movies;
    }
}