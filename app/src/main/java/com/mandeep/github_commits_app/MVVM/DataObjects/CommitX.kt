package com.mandeep.github_commits_app.MVVM.DataObjects

data class CommitX(
    val author: AuthorX,
    val comment_count: Int,
    val committer: Committer,
    val message: String,
    val tree: Tree,
    val url: String,
    val verification: Verification
)