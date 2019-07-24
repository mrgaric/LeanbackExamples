package fm.finch.tv_test_project.browse

import android.os.Bundle
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter


class MainFragment : BrowseSupportFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {

        headersState = HEADERS_HIDDEN

        title = "Finch"

        val browseAdapter = ArrayObjectAdapter(ListRowPresenter())

        val rowsAdapter = ArrayObjectAdapter(TextPresenter())

        rowsAdapter.add("Элемент 1")
        rowsAdapter.add("Элемент 2")
        rowsAdapter.add("Элемент 3")

        val firstHeader = HeaderItem("Заголовок 1")
        val secondHeader = HeaderItem("Заголовок 2")
        val thirdHeader = HeaderItem("Заголовок 3")

        browseAdapter.add(ListRow(firstHeader, rowsAdapter))
        browseAdapter.add(ListRow(secondHeader, rowsAdapter))
        browseAdapter.add(ListRow(thirdHeader, rowsAdapter))

        adapter = browseAdapter

    }

}
