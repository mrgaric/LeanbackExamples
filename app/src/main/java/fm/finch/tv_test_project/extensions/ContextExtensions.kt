package fm.finch.tv_test_project.extensions

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.getColorRes(@ColorRes id: Int) =
		ContextCompat.getColor(this, id)

fun Context.getDrawableRes(@DrawableRes id: Int) =
	ContextCompat.getDrawable(this, id)