package fm.finch.tv_test_project

import android.os.Bundle
import android.support.v17.leanback.app.RowsSupportFragment
import android.support.v17.leanback.widget.*
import fm.finch.tv_test_project.card.CardItem
import fm.finch.tv_test_project.card.CardPresenter
import fm.finch.tv_test_project.card.TitleHeaderPresenter
import fm.finch.tv_test_project.leanbackCard.LeanbackCardItem
import fm.finch.tv_test_project.leanbackCard.LeanbackCardPresenter

class MainFragment : RowsSupportFragment() {

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		initViewAsCardPresenter(savedInstanceState)
		setOnItemViewClickedListener { _, _, _, _ ->  }
	}

	private fun initViewAsCardPresenter(savedInstanceState: Bundle?) {
		val cardAdapter = ArrayObjectAdapter(CardPresenter())
		cardAdapter.addAll(0, getCardItems())
		setCardAdapter(cardAdapter)
	}

	private fun initViewAsLeanbackCardPresenter(savedInstanceState: Bundle?) {
		val cardAdapter = ArrayObjectAdapter(LeanbackCardPresenter())
		cardAdapter.addAll(0, getLeanbackCardItems())
		setCardAdapter(cardAdapter)
	}

	private fun setCardAdapter(cardAdapter: ArrayObjectAdapter) {
		val header = HeaderItem("Finch")
		val rowPresenter = ListRowPresenter()
			.apply {
				headerPresenter = TitleHeaderPresenter(40f,100)
			}
		val rowsAdapter = ArrayObjectAdapter(rowPresenter)
		rowsAdapter.add(ListRow(header, cardAdapter))
		adapter = rowsAdapter
	}

	private fun getLeanbackCardItems(): List<LeanbackCardItem> =
		listOf(
			LeanbackCardItem(
				title = "title 1",
				content = "content 1",
				image = R.drawable.image1,
				badgeIcon = R.drawable.app_icon_your_company
			),
			LeanbackCardItem(
				title = "title 2",
				content = "content 2",
				image = R.drawable.image2,
				badgeIcon = R.drawable.app_icon_your_company
			),
			LeanbackCardItem(
				title = "title 3",
				content = "content 3",
				image = R.drawable.image3,
				badgeIcon = R.drawable.app_icon_your_company
			),
			LeanbackCardItem(
				title = "title 4",
				content = "content 4",
				image = R.drawable.image4,
				badgeIcon = R.drawable.app_icon_your_company
			),
			LeanbackCardItem(
				title = "title 5",
				content = "content 5",
				image = R.drawable.image5,
				badgeIcon = R.drawable.app_icon_your_company
			),
			LeanbackCardItem(
				title = "title 6",
				content = "content 6",
				image = R.drawable.image6,
				badgeIcon = R.drawable.app_icon_your_company
			)
		)

	private fun getCardItems(): List<CardItem> =
			listOf(
				CardItem("title 1", R.drawable.image1),
				CardItem("title 2", R.drawable.image2),
				CardItem("title 3", R.drawable.image3),
				CardItem("title 4", R.drawable.image4),
				CardItem("title 5", R.drawable.image5),
				CardItem("title 6", R.drawable.image6)
			)

}
