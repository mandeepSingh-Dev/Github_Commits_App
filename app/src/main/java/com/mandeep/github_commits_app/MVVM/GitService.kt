package com.mandeep.github_commits_app.MVVM

import androidx.paging.PagingData
import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import com.mandeep.github_commits_app.MVVM.DataObjects.CommitItem
import com.mandeep.github_commits_app.MVVM.DataObjects.CommitX
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitService {

    @GET("/repos/square/retrofit/commits")
    suspend fun getCommits(@Query("page") page:Int, @Query("per_page") per_page:Int): Response<List<CommitItem>>

    @GET("/repos/square/retrofit/commits")
    fun getCommitItem():Call<List<CommitItem>>

  //  fun getOP():PagingData

    @GET("/repos/square/retrofit/commits")
    fun getCommitsOfAuthor(@Query("author") author:String):Call<List<CommitItem>>



    //fun getCommits(): Call<List<CommitX>>
}