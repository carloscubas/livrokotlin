package br.cubas.acessorest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.ProgressBar
import br.cubas.acessorest.api.ApiClient
import br.cubas.acessorest.api.ApiService
import br.cubas.acessorest.models.MovieData
import br.cubas.acessorest.utils.Constants.API_KEY
import kotlinx.android.synthetic.main.activity_acesso_rest.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AcessoRestRetrofitt : AppCompatActivity() {

    var apiServices: ApiService? = null
    var progressBarWaiting: ProgressBar? = null
    var recyclerView: RecyclerView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acesso_rest)

        recyclerView = movie_list_recyclerview
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView?.layoutManager = layoutManager

        progressBarWaiting = progressBarLayout
    }

    override fun onResume() {
        super.onResume()

        getMovies()
    }

    private fun getMovies() {
        apiServices = ApiClient.getClient().create(ApiService::class.java)

        var call = apiServices?.findMovies(API_KEY,"movie","brazil", 1, "application/json")
        call?.enqueue(object : Callback<MovieData> {

            init {
                progressBarWaiting?.visibility = View.VISIBLE
            }

            override fun onResponse(call: Call<MovieData>, response: Response<MovieData>) {
                if (response.isSuccessful) {
                    var movieData = response.body()
                    recyclerView?.adapter = MovieListAdapter(movieData?.Search, applicationContext)
                    progressBarWaiting?.visibility = View.INVISIBLE
                }
                progressBarWaiting?.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<MovieData>, t: Throwable) {
                progressBarWaiting?.visibility = View.INVISIBLE
                alert("Erro ao tentar ler os filmes") {
                    title = "Erro"
                    negativeButton("ok") {toast("Erro!!!")}
                }.show()
            }
        })
    }

}
