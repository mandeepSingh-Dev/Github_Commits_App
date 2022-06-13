package com.mandeep.github_commits_app.MVVM.DataObjects

data class Verification(
    val payload: Any,
    val reason: String,
    val signature: Any,
    val verified: Boolean
)