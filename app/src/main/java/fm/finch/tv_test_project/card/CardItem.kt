package fm.finch.tv_test_project.card

import android.support.annotation.DrawableRes

data class CardItem(
	val title: String,
	@DrawableRes
	val image: Int
)