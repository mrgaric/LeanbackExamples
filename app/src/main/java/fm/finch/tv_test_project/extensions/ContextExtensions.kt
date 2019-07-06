package fm.finch.tv_test_project.extensions

import android.content.Context
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat

fun Context.getColorRes(@ColorRes id: Int) =
		ContextCompat.getColor(this, id)