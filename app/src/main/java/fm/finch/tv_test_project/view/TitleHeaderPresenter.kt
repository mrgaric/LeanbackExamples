package fm.finch.tv_test_project.view

import android.support.v17.leanback.widget.Presenter
import android.support.v17.leanback.widget.RowHeaderPresenter
import android.support.v17.leanback.widget.RowHeaderView
import android.view.ViewGroup
import fm.finch.tv_test_project.R

class TitleHeaderPresenter(
	private val textSize: Float,
	private val bottom: Int
) : RowHeaderPresenter() {

	override fun onCreateViewHolder(parent: ViewGroup?): Presenter.ViewHolder =
		super.onCreateViewHolder(parent)
			.apply {
				val rowHeaderView = view.findViewById(R.id.row_header) as RowHeaderView
				rowHeaderView.textSize = textSize
				rowHeaderView.setPadding(0, 0, 0, bottom)
			}

}