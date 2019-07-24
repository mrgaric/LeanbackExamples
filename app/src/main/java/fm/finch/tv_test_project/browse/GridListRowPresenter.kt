package fm.finch.tv_test_project.browse

import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.RowPresenter

class GridListRowPresenter : ListRowPresenter() {

    override fun onBindRowViewHolder(holder: RowPresenter.ViewHolder, item: Any) {
        (holder as ViewHolder).gridView.setNumRows((item as? GridListRow)?.numRows ?: 1)
        super.onBindRowViewHolder(holder, item)
    }

    override fun isUsingDefaultShadow(): Boolean = false

}