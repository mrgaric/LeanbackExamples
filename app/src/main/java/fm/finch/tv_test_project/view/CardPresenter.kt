package fm.finch.tv_test_project.view

import android.support.v17.leanback.widget.Presenter
import android.view.ViewGroup
import fm.finch.tv_test_project.R
import fm.finch.tv_test_project.extensions.getDimensionPixelSizeRes

class CardPresenter : Presenter() {

	override fun onCreateViewHolder(viewGroup: ViewGroup): Presenter.ViewHolder =
		ViewHolder(createView(viewGroup))

	private fun createView(viewGroup: ViewGroup) =
		viewGroup
			.context
			.let { context ->
				CardView(context)
					.apply {
						layoutParams = ViewGroup.LayoutParams(
							context.getDimensionPixelSizeRes(R.dimen.card_width),
							context.getDimensionPixelSizeRes(R.dimen.card_height)
						)
					}
			}

	override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) =
		(viewHolder as ViewHolder)
			.bind(item as CardItem)

	override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) =
		(viewHolder as ViewHolder)
			.unbind()

	private inner class ViewHolder(view: CardView) : Presenter.ViewHolder(view) {
		fun bind(menuItem: CardItem) =
			(view as CardView).bind(menuItem)

		fun unbind() =
			(view as CardView).unbind()

	}

}