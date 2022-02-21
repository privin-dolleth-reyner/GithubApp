package `in`.privin.githubapp

import `in`.privin.githubapp.data.GithubRepository
import android.app.Application

class App: Application() {

    init {
        app = this
    }

    companion object{
        private var app: App? = null
        fun getInstance() = app ?: App()
    }

    val githubRepository: GithubRepository by lazy {
        GithubRepository()
    }




}