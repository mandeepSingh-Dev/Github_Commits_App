package com.mandeep.github_commits_app.paging

import android.provider.ContactsContract
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import com.mandeep.github_commits_app.MVVM.DataObjects.CommitItem
import com.mandeep.github_commits_app.MVVM.GitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class PostDataSource(val gitService: GitService): PagingSource<Int, CommitItem>() {
    override fun getRefreshKey(state: PagingState<Int, CommitItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CommitItem> {
       try {
           Log.d("3r9f3jf",params.loadSize.toString())


           var currentLoadingPageKey = params.key ?: 1
           Log.d("3r9fh3f",currentLoadingPageKey.toString())
           val commitItemList = mutableListOf<CommitItem>()


           val callCommit = gitService.getCommits(currentLoadingPageKey,params.loadSize)
           callCommit.body()?.let {
               commitItemList.addAll(it)
               Log.d("3r9fh3fcommitlist",commitItemList.size.toString()+"   SIZE OF LIST" )
           }
        /*   callCommit.enqueue(object : Callback<List<CommitItem>> {
               override fun onResponse(call: Call<List<CommitItem>>, response: Response<List<CommitItem>>) {

                   response.body()?.let {
                       Log.d("3r9fh3f",it.size.toString()+"   SIZE OF LIST" )
                       commitItemList.addAll(it)

                       Log.d("3r9fh3fcommitlist",commitItemList.size.toString()+"   SIZE OF LIST" )

                   }
               }
               override fun onFailure(call: Call<List<CommitItem>>, t: Throwable) {
                  // currentLoadingPageKey = 1
               }
           })*/

         /*  val prevkey = if (currentLoadingPageKey > 0)
           {  currentLoadingPageKey - 1}
               else
           {null}
*/
           val prevkey = if (currentLoadingPageKey == 1)
           { null}
           else
           {currentLoadingPageKey-1 }

           Log.d("4t8gh4g",prevkey.toString()+"    prevkey")
           Log.d("4t8gh4g",currentLoadingPageKey.toString()+"    currentLoadingPageKey\n")



           val nextKey = if (commitItemList.isEmpty())
                         { null
                             Log.d("3t9jnef","kfnsdf")
                            }
                            else { currentLoadingPageKey + 1 }

           Log.d("4t8gh4g",nextKey.toString()+"    nextKey")

           val page = LoadResult.Page(commitItemList, prevkey, nextKey)
           return page
       }catch (e:Exception){
           return LoadResult.Error(e)
       }
    }

}