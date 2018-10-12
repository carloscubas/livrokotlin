package br.cubas.acessorest

import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_acesso_rest.*
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar

class AcessoRest : AppCompatActivity() {

    var progressBarWaiting: ProgressBar? = null
    var recyclerView: RecyclerView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acesso_rest)

        recyclerView = movie_list_recyclerview
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView?.layoutManager = layoutManager

        progressBarWaiting = progressBar1

        buscaFilmes(this).execute();
    }

    inner class buscaFilmes(context: Context) : AsyncTask<Void, Void, String>() {

        private val context: Context

        init {
            this.context = context.applicationContext
        }

        override fun onPreExecute() {
            super.onPreExecute()
            progressBarWaiting?.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: Void?): String? {
            val url = Uri.parse(Constants.URLSERVIDOR).toString()
            val contents = Util.acessar(url)
            return contents
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            var listMovies = Util.movieConverter(result)
            recyclerView?.adapter = MovieListAdapter(listMovies, context)
            progressBarWaiting?.visibility = View.INVISIBLE
        }
    }
}