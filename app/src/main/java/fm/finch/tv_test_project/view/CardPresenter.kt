package fm.finch.tv_test_project.view

import android.support.v17.leanback.widget.Presenter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import fm.finch.tv_test_project.R
import kotlinx.android.synthetic.main.item_card.view.*

class CardPresenter : Presenter() {
	override fun onCreateViewHolder(viewGroup: ViewGroup): Presenter.ViewHolder =
		ViewHolder(createView(viewGroup))

	private fun createView(viewGroup: ViewGroup) =
		LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card, viewGroup, false)
			.apply {
				isFocusable = true
				isFocusableInTouchMode = true
			}

	override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) =
		(viewHolder as ViewHolder)
			.bind(item as CardItem)

	override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) =
		(viewHolder as ViewHolder)
			.unbind()

	private inner class ViewHolder(view: View) : Presenter.ViewHolder(view) {

		private var requestManager: RequestManager? = null

		fun bind(menuItem: CardItem) = with(view) {
			menuItem.run {
				requestManager = Glide.with(vImage)
				requestManager?.load(image)?.into(vImage)
				vTitle.text = title
			}
		}

		fun unbind() = with(view) {
			requestManager?.clear(vImage)
			vImage.setImageDrawable(null)
			vTitle.text = ""
		}
	}
}