package fm.finch.tv_test_project.leanbackCard

import android.support.annotation.DrawableRes

data class LeanbackCardItem(
	val title: String,
	val content: String,
	@DrawableRes
	val image: Int,
	@DrawableRes
	val badgeIcon: Int
)