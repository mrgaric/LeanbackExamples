package fm.finch.tv_test_project.browse

import android.os.Bundle
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter


class PageRowsFragment : RowsSupportFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    private fun initView() {

        val pageId = arguments?.getLong(PAGE_ID)

        val headerTitle = pageId?.let { "Страница $pageId" } ?: ""

        val outerAdapter = ArrayObjectAdapter(ListRowPresenter())

        val rowsAdapter = ArrayObjectAdapter(TextPresenter())

        val commonHeader = HeaderItem(headerTitle)

        rowsAdapter.add("Элемент 1")
        rowsAdapter.add("Элемент 2")
        rowsAdapter.add("Элемент 3")

        outerAdapter.add(ListRow(commonHeader, rowsAdapter))
        outerAdapter.add(ListRow(commonHeader, rowsAdapter))
        outerAdapter.add(ListRow(commonHeader, rowsAdapter))
        outerAdapter.add(ListRow(commonHeader, rowsAdapter))

        adapter = outerAdapter

    }

    companion object {
        private const val PAGE_ID = "page id"

        fun newInstance(pageId: Long) = PageRowsFragment()
            .apply {
                val bundle = Bundle()
                bundle.putLong(PAGE_ID, pageId)
                arguments = bundle
            }
    }
}