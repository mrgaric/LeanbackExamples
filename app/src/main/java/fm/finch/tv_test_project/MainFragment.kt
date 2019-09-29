package fm.finch.tv_test_project

import android.os.Bundle
import android.support.v17.leanback.app.RowsSupportFragment
import android.support.v17.leanback.widget.*
import fm.finch.tv_test_project.view.CardItem
import fm.finch.tv_test_project.view.CardPresenter
import fm.finch.tv_test_project.view.TitleHeaderPresenter

class MainFragment : RowsSupportFragment() {

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		initView(savedInstanceState)
	}

	private fun initView(savedInstanceState: Bundle?) {

		val outerAdapter = ArrayObjectAdapter(getOuterPresenter())
		val cardAdapter = ArrayObjectAdapter(CardPresenter())

		val header = HeaderItem("Finch")
		cardAdapter.addAll(0, getItems())

		outerAdapter.add(ListRow(header, cardAdapter))

		adapter = outerAdapter

		setOnItemViewClickedListener { _, _, _, _ ->  }

	}

	private fun getOuterPresenter() =
		ListRowPresenter()
			.apply {
				headerPresenter = TitleHeaderPresenter(40f,100)
			}

	private fun getItems(): List<CardItem> =
			listOf(
				CardItem("title 1", R.drawable.image1),
				CardItem("title 2", R.drawable.image2),
				CardItem("title 3", R.drawable.image3),
				CardItem("title 4", R.drawable.image4),
				CardItem("title 5", R.drawable.image5),
				CardItem("title 6", R.drawable.image6)
			)

}
