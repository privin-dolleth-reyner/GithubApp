package `in`.privin.githubapp.data.remote

import `in`.privin.githubapp.data.model.PullRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface GithubRemoteClient {

    companion object {
        private const val USER = "privin-dolleth-reyner"
        private const val REPO = "Test"
        private const val PR_CLOSED_REQUEST = "repos/$USER/$REPO/pulls?state=closed"
    }

    @GET(PR_CLOSED_REQUEST)
    fun getClosedPullRequests(): Call<List<PullRequest>>

}