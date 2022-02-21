package `in`.privin.githubapp.ui

import `in`.privin.githubapp.data.model.PullRequest
import androidx.recyclerview.widget.DiffUtil

class PrDiffCallback constructor(
    private val oldPrList: List<PullRequest>,
    private val newPrList: List<PullRequest>
): DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return oldPrList.size
    }

    override fun getNewListSize(): Int {
        return newPrList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPrList[oldItemPosition].title == newPrList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPrList[oldItemPosition].title == newPrList[newItemPosition].title
    }
}