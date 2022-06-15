package com.mandeep.github_commits_app.MVVM

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import com.mandeep.github_commits_app.MVVM.DataObjects.CommitItem
import com.mandeep.github_commits_app.paging.PostDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(val mainRepositry: MainRepositry):ViewModel() {

      val livecommits: MutableLiveData<List<CommitItem>> = MutableLiveData()

    val listData = Pager(PagingConfig(pageSize = 10)){
        PostDataSource(mainRepositry.gitService)
    }.flow.cachedIn(viewModelScope)

    init {
      /*  mainRepositry.getCommits(1,).enqueue(object:Callback<List<CommitItem>>{
            override fun onResponse(call: Call<List<CommitItem>>, response: Response<List<CommitItem>>) {

               livecommits.value = response.body()
            }

            override fun onFailure(call: Call<List<CommitItem>>, t: Throwable) {
                Log.d("efief",t.message.toString())
            }
        })*/

    }
}