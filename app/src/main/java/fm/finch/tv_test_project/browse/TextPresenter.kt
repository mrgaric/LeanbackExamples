package fm.finch.tv_test_project.browse

import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.Presenter


class TextPresenter : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view = TextView(parent.context)
        view.layoutParams = ViewGroup.LayoutParams(600, 400)
        view.isFocusable = true
        view.isFocusableInTouchMode = true
        view.setBackgroundColor(
            ContextCompat.getColor(
                parent.context,
                android.R.color.background_light
            )
        )
        view.gravity = Gravity.CENTER
        view.setTextColor(Color.BLACK)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val textView = viewHolder.view as TextView
        val textItem = item as TextItem
        textView.text = textItem.text
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        val textView = viewHolder.view as TextView
        textView.text = ""
    }
}