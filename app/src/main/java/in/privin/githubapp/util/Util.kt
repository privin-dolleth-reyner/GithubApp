package `in`.privin.githubapp.util

import android.annotation.SuppressLint
import android.util.Log
import java.text.SimpleDateFormat

object Util {
    private const val TAG = "Util"

    @SuppressLint("SimpleDateFormat")
    fun getTimeFormat(s: String): String {
        return try {
            val oldFormat = "yyyy-mm-dd'T'hh:mm:ss'Z'"
            val newFormat = "dd MMM yy hh:mm:ss"
            val sdf = SimpleDateFormat(oldFormat)
            val date = sdf.parse(s)!!
            sdf.applyPattern(newFormat)
            sdf.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, e.localizedMessage ?: "Exception")
            "Exception"
        }
    }

}