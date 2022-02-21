package `in`.privin.githubapp.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ListItemDecoration constructor(
    private val verticalSpace: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = verticalSpace
        outRect.top = verticalSpace
    }
}