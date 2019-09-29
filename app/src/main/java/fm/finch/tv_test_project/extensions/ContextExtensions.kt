package fm.finch.tv_test_project.extensions

import android.content.Context
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat

fun Context.getColorRes(@ColorRes id: Int) =
		ContextCompat.getColor(this, id)

fun Context.getDrawableRes(@DrawableRes id: Int) =
	ContextCompat.getDrawable(this, id)

fun Context.getDimensionPixelSizeRes(@DimenRes id: Int) =
	this.resources.getDimensionPixelSize(id)