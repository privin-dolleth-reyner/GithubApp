package `in`.privin.githubapp.ui

import `in`.privin.githubapp.data.GithubRepository
import `in`.privin.githubapp.data.Result
import `in`.privin.githubapp.data.model.PullRequest
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel constructor(
    private val githubRepository: GithubRepository
): ViewModel() {

    companion object{
        private const val TAG = "HomeViewModel"
    }

    private val _prList = MutableLiveData<List<PullRequest>>()

    val prList get() = _prList

    fun getClosedPrList() = githubRepository.getClosedPullRequests{
        when(it){
            is Result.Success -> {
                _prList.value = it.data
                Log.d(TAG, "returned: ${it.data}")
            }
            is Result.Error ->{
                Log.e(TAG, "returned: ${it.error}")
            }
        }
    }

    fun getRepoName() = githubRepository.getRepoName()

    fun getUserName() = githubRepository.getUserName()


}