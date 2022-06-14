package com.mandeep.github_commits_app.MVVM
import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import com.mandeep.github_commits_app.MVVM.DataObjects.CommitItem
import dagger.hilt.*
import retrofit2.Call
import retrofit2.http.Query
import javax.inject.Inject

class MainRepositry @Inject constructor(val gitService: GitService)
{

    fun getCommits(page:Int): Call<Commit> = gitService.getCommits(page)

    fun getCommitItem(): Call<List<CommitItem>> = gitService.getCommitItem()

    fun getCommitsOfAuthor(author:String):Call<List<CommitItem>> = gitService.getCommitsOfAuthor(author)


}