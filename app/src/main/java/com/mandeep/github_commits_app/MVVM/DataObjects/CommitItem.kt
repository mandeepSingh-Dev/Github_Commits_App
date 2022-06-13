package com.mandeep.github_commits_app.MVVM.DataObjects

data class CommitItem(
    val author: Author,
    val comments_url: String,
    val commit: CommitX,
    val committer: CommitterX,
    val html_url: String,
    val node_id: String,
    val parents: List<Parent>,
    val sha: String,
    val url: String
)