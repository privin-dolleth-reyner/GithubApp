package `in`.privin.githubapp.ui

import `in`.privin.githubapp.R
import `in`.privin.githubapp.data.model.PullRequest
import `in`.privin.githubapp.databinding.ItemPrViewBinding
import `in`.privin.githubapp.util.Util
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class GithubPrListAdapter constructor(
    private val context: Context,
    private var list: List<PullRequest>
) : RecyclerView.Adapter<GithubPrListAdapter.PrItemViewHolder>() {


    fun updateData(list: List<PullRequest>) {
        val diff = PrDiffCallback(this.list, list)
        val result = DiffUtil.calculateDiff(diff)
        this.list = list
        result.dispatchUpdatesTo(this)
    }

    class PrItemViewHolder(val binding: ItemPrViewBinding) : RecyclerView.ViewHolder(binding.root){
        private fun target(context: Context, description: String) = object : CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                val bitmap = Bitmap.createScaledBitmap(resource, 24, 24, false)

                val imageSpan = ImageSpan(context, bitmap, ImageSpan.ALIGN_BASELINE)
                val span = SpannableStringBuilder(" ")
                span.setSpan(imageSpan,0 ,1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
                span.append(" ")
                span.append(description)
                binding.tvClosed.text = span
            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }

        }

        fun loadProfileImage(context: Context, url: String, description: String){
            Glide
                .with(binding.root)
                .asBitmap()
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_merged)
                .into(target(context,description))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPrViewBinding.inflate(inflater, parent, false)
        return PrItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PrItemViewHolder, position: Int) {
        val pr = list[position]
        holder.binding.title.text = pr.title
        val createdAt = Util.getTimeFormat(pr.created_at)
        val closedAt = Util.getTimeFormat(pr.closed_at)
        holder.binding.tvCreated.text = context.getString(R.string.pr_created, createdAt)
        val description = context.getString(R.string.pr_description, pr.user.login, closedAt)
        holder.loadProfileImage(context, pr.user.avatar_url, description)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}