package `in`.privin.githubapp

import `in`.privin.githubapp.data.GithubRepository
import android.app.Application

class App : Application() {

    init {
        app = this
    }

    companion object {
        private var app: App? = null
        fun getInstance() = app ?: throw IllegalStateException("Application instance is null")
    }

    val githubRepository: GithubRepository by lazy {
        GithubRepository()
    }

}