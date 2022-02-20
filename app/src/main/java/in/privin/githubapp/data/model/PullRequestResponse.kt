package `in`.privin.githubapp.data.model

import `in`.privin.githubapp.data.Model
import com.squareup.moshi.Json


data class PullRequest(
    @Json(name = "title")
    val title: String,

    @Json(name = "created_at")
    val created_at: String,

    @Json(name = "closed_at")
    val closed_at: String,

    @Json(name = "user")
    val user: User,
): Model

data class User(
    @Json(name = "login")
    val login: String,

    @Json(name = "avatar_url")
    val avatar_url: String
)