package fm.finch.tv_test_project.browse

import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager


class ImagePresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view = ImageView(parent.context)
        view.layoutParams = ViewGroup.LayoutParams(600, 400)
        view.isFocusable = true
        view.isFocusableInTouchMode = true
        view.scaleType = ImageView.ScaleType.CENTER_CROP
        view.setBackgroundColor(
            ContextCompat.getColor(
                parent.context,
                android.R.color.background_light
            )
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder?, item: Any?) =
        (viewHolder as ViewHolder).bind(item as ImageItem)

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder?) =
        (viewHolder as ViewHolder).unbind()

    class ViewHolder(private val imageView: ImageView) : Presenter.ViewHolder(imageView) {

        private var requestManager: RequestManager? = null

        fun bind(imageItem: ImageItem) {
            requestManager = Glide.with(imageView)
            requestManager?.load(imageItem.imageId)?.into(imageView)
        }

        fun unbind() {
            requestManager?.clear(imageView)
            imageView.setImageDrawable(null)
        }
    }
}