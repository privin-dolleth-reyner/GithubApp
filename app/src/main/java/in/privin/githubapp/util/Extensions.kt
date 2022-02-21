package `in`.privin.githubapp.util

import `in`.privin.githubapp.R
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String){
    Glide
        .with(this)
        .load(url)
        .circleCrop()
        .placeholder(R.drawable.ic_merged)
        .into(this);
}
