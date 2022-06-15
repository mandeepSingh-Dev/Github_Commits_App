package com.mandeep.github_commits_app.MVVM
import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import com.mandeep.github_commits_app.MVVM.DataObjects.CommitItem
import dagger.hilt.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject

class MainRepositry @Inject constructor(val gitService: GitService)
{

   suspend fun getCommits(page:Int,per_page:Int): Response<List<CommitItem>> = gitService.getCommits(page,per_page)

    fun getCommitItem(): Call<List<CommitItem>> = gitService.getCommitItem()

    fun getCommitsOfAuthor(author:String):Call<List<CommitItem>> = gitService.getCommitsOfAuthor(author)


}