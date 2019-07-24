package fm.finch.tv_test_project.browse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.Row
import androidx.leanback.widget.RowHeaderPresenter
import fm.finch.tv_test_project.R
import kotlinx.android.synthetic.main.item_icon_header.view.textView


class IconRowHeaderPresenter : RowHeaderPresenter() {

    override fun onCreateViewHolder(viewGroup: ViewGroup): ViewHolder {
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.item_icon_header, viewGroup, false)
        val viewHolder = ViewHolder(view)
        setSelectLevel(viewHolder, 0f)
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, data: Any) {
        val row = data as? Row
        val iconHeaderItem = row?.headerItem as? IconHeaderItem
        iconHeaderItem?.let {
            val tv = viewHolder
                .view
                .textView
            if (iconHeaderItem.iconResId != IconHeaderItem.NO_ICON) {
                tv.setCompoundDrawablesWithIntrinsicBounds(iconHeaderItem.iconResId, 0, 0, 0)
            }
            tv.text = iconHeaderItem.name
        }
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) {
        val tv = viewHolder
            .view
            .textView
        tv.text = ""
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
    }
}
