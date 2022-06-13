package com.mandeep.github_commits_app.MVVM

import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import com.mandeep.github_commits_app.MVVM.DataObjects.CommitX
import retrofit2.Call
import retrofit2.http.GET

interface GitService {

    @GET("/repos/mandeepSingh-Dev/Online-Music-Application/commits")
    fun getCommits(): Call<Commit>

    //fun getCommits(): Call<List<CommitX>>
}