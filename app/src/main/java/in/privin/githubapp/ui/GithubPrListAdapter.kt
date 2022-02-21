package `in`.privin.githubapp.ui

import `in`.privin.githubapp.R
import `in`.privin.githubapp.data.model.PullRequest
import `in`.privin.githubapp.databinding.ItemPrViewBinding
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

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

    class PrItemViewHolder(val binding: ItemPrViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPrViewBinding.inflate(inflater, parent, false)
        return PrItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PrItemViewHolder, position: Int) {
        val pr = list[position]
        holder.binding.title.text = pr.title
        val createdAt = pr.created_at
        holder.binding.tvCreated.text = context.getString(R.string.pr_created, createdAt)
        holder.binding.tvClosed.text = context.getString(R.string.pr_description, pr.user.login, pr.closed_at)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}