package com.mandeep.github_commits_app.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(val mainRepositry: MainRepositry):ViewModel() {

      val livecommits: MutableLiveData<Commit> = MutableLiveData()

    init {
        mainRepositry.getCommits().enqueue(object:Callback<Commit>{
            override fun onResponse(call: Call<Commit>, response: Response<Commit>) {
               livecommits.value = response.body()
            }

            override fun onFailure(call: Call<Commit>, t: Throwable) {

            }
        })

    }
}