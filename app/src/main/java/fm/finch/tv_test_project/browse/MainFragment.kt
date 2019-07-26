package fm.finch.tv_test_project.browse

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.ClassPresenterSelector
import androidx.leanback.widget.DividerRow
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.PageRow
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.PresenterSelector
import androidx.leanback.widget.Row
import androidx.leanback.widget.SectionRow
import fm.finch.tv_test_project.R

class MainFragment : BrowseSupportFragment() {

    private val listRowFragmentFactory = object : FragmentFactory<Fragment>() {
        override fun createFragment(row: Any): Fragment =
            ListRowsFragment.newInstance()
    }

    private val pageRowFragmentFactory = object : FragmentFactory<Fragment>() {
        override fun createFragment(row: Any): Fragment? =
            (row as? PageRow)
                ?.headerItem
                ?.id
                ?.let {
                    PageRowsFragment.newInstance(it)
                }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {

        headersState = HEADERS_HIDDEN

        title = "Finch"

        setHeaderPresenterSelector(object : PresenterSelector() {
            val presenter = IconRowHeaderPresenter()
            val defaultPresenterSelector = headersSupportFragment.presenterSelector
            override fun getPresenter(data: Any): Presenter {
                return if ((data as? Row)?.headerItem is IconHeaderItem)
                    presenter
                else
                    defaultPresenterSelector.getPresenter(data)
            }
        })

        setupList()

    }

    private fun setupList() {

        mainFragmentRegistry.registerFragment(GridListRow::class.java, listRowFragmentFactory)

        val browseAdapter = ArrayObjectAdapter(ListRowPresenter())

        val rowsPresenterSelector = ClassPresenterSelector()
            .addClassPresenter(ImageItem::class.java, ImagePresenter())
            .addClassPresenter(TextItem::class.java, TextPresenter())

        val rowsAdapter = ArrayObjectAdapter(rowsPresenterSelector)

        rowsAdapter.add(ImageItem(R.drawable.image1))
        rowsAdapter.add(ImageItem(R.drawable.image2))
        rowsAdapter.add(ImageItem(R.drawable.image3))
        rowsAdapter.add(ImageItem(R.drawable.image4))
        rowsAdapter.add(ImageItem(R.drawable.image5))
        rowsAdapter.add(ImageItem(R.drawable.image6))

        rowsAdapter.add(TextItem("Элемент 1"))
        rowsAdapter.add(TextItem("Элемент 2"))
        rowsAdapter.add(TextItem("Элемент 3"))
        rowsAdapter.add(TextItem("Элемент 4"))
        rowsAdapter.add(TextItem("Элемент 5"))
        rowsAdapter.add(TextItem("Элемент 6"))
        rowsAdapter.add(TextItem("Элемент 7"))
        rowsAdapter.add(TextItem("Элемент 8"))
        rowsAdapter.add(TextItem("Элемент 9"))
        rowsAdapter.add(TextItem("Элемент 10"))
        rowsAdapter.add(TextItem("Элемент 11"))
        rowsAdapter.add(TextItem("Элемент 12"))

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

    private fun setupPage() {

        mainFragmentRegistry.registerFragment(PageRow::class.java, pageRowFragmentFactory)

        val browseAdapter = ArrayObjectAdapter(ListRowPresenter())

        val firstHeader = IconHeaderItem("Заголовок 1", 1, R.drawable.ic_header_item)
        val secondHeader = IconHeaderItem("Заголовок 2", 2, R.drawable.ic_header_item)
        val thirdHeader = IconHeaderItem("Заголовок 3", 3, R.drawable.ic_header_item)

        browseAdapter.add(PageRow(firstHeader))
        browseAdapter.add(DividerRow())
        browseAdapter.add(PageRow(secondHeader))
        browseAdapter.add(DividerRow())
        browseAdapter.add(PageRow(thirdHeader))
        browseAdapter.add(SectionRow("Подзаголовок 1"))

        adapter = browseAdapter

    }

}
