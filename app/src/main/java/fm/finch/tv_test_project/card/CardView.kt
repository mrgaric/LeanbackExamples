package fm.finch.tv_test_project.card

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import fm.finch.tv_test_project.R
import fm.finch.tv_test_project.extensions.getDrawableRes
import kotlinx.android.synthetic.main.item_card.view.*

class CardView(context: Context) : FrameLayout(context) {

	private var requestManager: RequestManager? = null

	init {
		View.inflate(context, R.layout.item_card, this)
		isFocusable = true
		isFocusableInTouchMode = true
		foreground = context.getDrawableRes(R.drawable.card_foreground)
	}

	fun bind(item: CardItem) {
		item.run {
			requestManager = Glide.with(vImage)
			requestManager?.load(image)?.into(vImage)
			vTitle.text = title
		}
	}

	fun unbind() {
		requestManager?.clear(vImage)
		vImage.setImageDrawable(null)
		vTitle.text = ""
	}

	override fun onCreateDrawableState(extraSpace: Int): IntArray {
		val states = super.onCreateDrawableState(extraSpace)
		var pressed = false
		var enabled = false
		states.forEach {
			if (it == android.R.attr.state_pressed) {
				pressed = true
			}
			if (it == android.R.attr.state_enabled) {
				enabled = true
			}
		}
		return if (pressed && enabled) {
			View.PRESSED_ENABLED_STATE_SET
		} else if (pressed) {
			View.PRESSED_STATE_SET
		} else if (enabled) {
			View.ENABLED_STATE_SET
		} else {
			View.EMPTY_STATE_SET
		}
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