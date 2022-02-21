package `in`.privin.githubapp.data.remote

import `in`.privin.githubapp.data.Result

class GithubRemoteDataSource {
    companion object {
        const val TAG = "GithubRemoteDataSource"
    }

    private val githubRemoteClient: GithubRemoteClient = Retrofit.create()

    fun getClosedPullRequests(): Result {
        val response = githubRemoteClient.getClosedPullRequests().execute()
        if (response.isSuccessful) {
            return Result.Success(response.body() as List)
        } else {
            return Result.Error(response.code().toString())
        }
    }
}