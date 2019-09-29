package fm.finch.tv_test_project.view

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import com.bumptech.glide.RequestManager
import fm.finch.tv_test_project.R
import kotlinx.android.synthetic.main.item_card.view.*

class CardView(context: Context) : FrameLayout(context) {

	private var requestManager: RequestManager? = null

	init {
		View.inflate(context, R.layout.item_card, this)
		isFocusable = true
		isFocusableInTouchMode = true
	}

	fun bind(menuItem: CardItem) {
		menuItem.run {
			requestManager = com.bumptech.glide.Glide.with(vImage)
			requestManager?.load(image)?.into(vImage)
			vTitle.text = title
		}
	}

	fun unbind() {
		requestManager?.clear(vImage)
		vImage.setImageDrawable(null)
		vTitle.text = ""
	}

	override fun setSelected(selected: Boolean) {
		super.setSelected(selected)
		vSelector.visibility =
			if (selected)
				View.VISIBLE
			else
				View.GONE
	}

}