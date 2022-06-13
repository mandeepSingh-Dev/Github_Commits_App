package com.mandeep.github_commits_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import com.mandeep.github_commits_app.MVVM.DataObjects.CommitX
import com.mandeep.github_commits_app.MVVM.GitService
import com.mandeep.github_commits_app.MVVM.MyAdapetr
import com.mandeep.github_commits_app.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val API = "https://api.github.com/"

    val mContext = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


            val retrofit = Retrofit.Builder().baseUrl(API).addConverterFactory(GsonConverterFactory.create()).build()
               val service = retrofit.create(GitService::class.java)

       /*service.getCommits().enqueue(object:Callback<List<CommitX>>{
           override fun onResponse(call: Call<List<CommitX>>, response: Response<List<CommitX>>) {
               Log.d("efignef",response.body()?.size.toString())
               response.body()?.forEach {
                //   Log.d("eigfne",it.message+"  ")
                   Log.d("eigfne",it.message)

               }
           }

           override fun onFailure(call: Call<List<CommitX>>, t: Throwable) {
               Log.d("efignef",t.toString())

           }
       })*/
        service.getCommits().enqueue(object:Callback<Commit>{
            override fun onResponse(call: Call<Commit>, response: Response<Commit>) {
                Log.d("-3rk3r3",response.body()?.size.toString())
                val commit = response.body()
                commit?.forEach {
                    Log.d("39trh3f",it.commit.message+"ii")

                    val myAdapetr = MyAdapetr(mContext, commit)
                    binding.recyclerView.layoutManager = LinearLayoutManager(mContext)
                    binding.recyclerView.adapter = myAdapetr

                }
            }

            override fun onFailure(call: Call<Commit>, t: Throwable) {
                Log.d("-3rk3r3",t.toString())
            }
        })


    }
}