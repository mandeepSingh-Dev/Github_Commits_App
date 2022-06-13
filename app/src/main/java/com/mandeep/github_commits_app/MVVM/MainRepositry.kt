package com.mandeep.github_commits_app.MVVM
import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import dagger.hilt.*
import retrofit2.Call
import javax.inject.Inject

class MainRepositry @Inject constructor(val gitService: GitService)
{

    fun getCommits(): Call<Commit> = gitService.getCommits()

}