package com.mandeep.github_commits_app.paging

import android.provider.ContactsContract
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import com.mandeep.github_commits_app.MVVM.GitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class PostDataSource(val gitService: GitService): PagingSource<Int, Commit>() {
    override fun getRefreshKey(state: PagingState<Int, Commit>): Int? {
     return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Commit> {
       try {
           val currentLoadingPageKey = params.key ?: 1
           val callCommit = gitService.getCommits(currentLoadingPageKey)
           val commit = mutableListOf<Commit>()

           callCommit.enqueue(object : Callback<Commit> {
               override fun onResponse(call: Call<Commit>, response: Response<Commit>) {
                   response.body()?.let {
                       commit.add(it)

                       Log.d("eifhe",it.size.toString())
                   }
               }

               override fun onFailure(call: Call<Commit>, t: Throwable) {

               }
           })

           val prevkey = if (currentLoadingPageKey == 1)
               null
           else
               currentLoadingPageKey - 1

           val page = LoadResult.Page(
               data = commit,
               prevKey = prevkey,
               nextKey = currentLoadingPageKey.plus(1)
           )
           return page
       }catch (e:Exception){
           return LoadResult.Error(e)
       }
    }
}