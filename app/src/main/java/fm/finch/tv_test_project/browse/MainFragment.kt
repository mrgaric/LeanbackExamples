package fm.finch.tv_test_project.browse

import android.os.Bundle
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.DividerRow
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.PresenterSelector
import androidx.leanback.widget.Row
import androidx.leanback.widget.SectionRow
import fm.finch.tv_test_project.R


class MainFragment : BrowseSupportFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {

        headersState = HEADERS_HIDDEN

        title = "Finch"

        setHeaderPresenterSelector(object : PresenterSelector() {
            val presenter = IconRowHeaderPresenter()
            val oldPresenterSelector =  headersSupportFragment.presenterSelector
            override fun getPresenter(data: Any): Presenter {
                return if ((data as? Row)?.headerItem is IconHeaderItem)
                    presenter
                else
                    oldPresenterSelector.getPresenter(data)
            }
        })

        val browseAdapter = ArrayObjectAdapter(ListRowPresenter())

        val rowsAdapter = ArrayObjectAdapter(TextPresenter())

        rowsAdapter.add("Элемент 1")
        rowsAdapter.add("Элемент 2")
        rowsAdapter.add("Элемент 3")

        val firstHeader = IconHeaderItem("Заголовок 1", iconResId = R.drawable.ic_header_item)
        val secondHeader = IconHeaderItem("Заголовок 2", iconResId = R.drawable.ic_header_item)
        val thirdHeader = IconHeaderItem("Заголовок 3", iconResId = R.drawable.ic_header_item)

        browseAdapter.add(ListRow(firstHeader, rowsAdapter))
        browseAdapter.add(DividerRow())
        browseAdapter.add(ListRow(secondHeader, rowsAdapter))
        browseAdapter.add(DividerRow())
        browseAdapter.add(ListRow(thirdHeader, rowsAdapter))
        browseAdapter.add(SectionRow("Подзаголовок 1"))

        adapter = browseAdapter

    }

}
