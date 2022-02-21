package `in`.privin.githubapp.data

interface Model

sealed class Result {
    data class Success(val data: Any): Result()
    data class Error(val error: String): Result()
}