package fm.finch.tv_test_project.browse

import androidx.leanback.app.RowsSupportFragment


class ListRowsFragment : RowsSupportFragment() {

    override fun setExpand(expand: Boolean) {
        super.setExpand(true)
    }

    companion object {
        fun newInstance() = ListRowsFragment()
    }
}