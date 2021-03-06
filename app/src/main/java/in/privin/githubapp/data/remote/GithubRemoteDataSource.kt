package `in`.privin.githubapp.data.remote

import `in`.privin.githubapp.data.Result
import `in`.privin.githubapp.data.model.PullRequest

class GithubRemoteDataSource {
    companion object {
        const val TAG = "GithubRemoteDataSource"
    }

    private val githubRemoteClient: GithubRemoteClient by lazy {
        Retrofit.create()
    }

    fun getClosedPullRequests(): Result<List<PullRequest>> {
        val response = githubRemoteClient.getClosedPullRequests().execute()
        return if (response.isSuccessful) {
            Result.Success(response.body() as List<PullRequest>)
        } else {
            Result.Error(response.code().toString())
        }
    }
}