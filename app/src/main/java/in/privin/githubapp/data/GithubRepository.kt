package `in`.privin.githubapp.data

import `in`.privin.githubapp.data.remote.GithubRemoteDataSource
import android.os.Handler
import android.os.Looper
import android.util.Log
import java.util.concurrent.*

class GithubRepository {
    companion object{
        private const val TAG = "GithubRepository"
    }

    private val githubRemoteDataSource by lazy {
        GithubRemoteDataSource()
    }

    private val NUM_OF_CORES = Runtime.getRuntime().availableProcessors()

    private val workQueue = LinkedBlockingQueue<Runnable>()

    private val executor = ThreadPoolExecutor(
        NUM_OF_CORES,
        NUM_OF_CORES,
        1,
        TimeUnit.SECONDS,
        workQueue
    )


    fun getClosedPullRequests(callback: (result: Result)-> Unit) = executor.execute {
        val result = githubRemoteDataSource.getClosedPullRequests()
        Handler(Looper.getMainLooper()).post { callback.invoke(result) }
    }
}