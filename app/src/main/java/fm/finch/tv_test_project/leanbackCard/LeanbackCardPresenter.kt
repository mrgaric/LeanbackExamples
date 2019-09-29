package fm.finch.tv_test_project.leanbackCard

import android.graphics.drawable.Drawable
import android.support.v17.leanback.widget.ImageCardView
import android.support.v17.leanback.widget.Presenter
import android.view.ContextThemeWrapper
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition
import fm.finch.tv_test_project.R
import fm.finch.tv_test_project.extensions.getDimensionPixelSizeRes

class LeanbackCardPresenter : Presenter() {

	override fun onCreateViewHolder(viewGroup: ViewGroup): Presenter.ViewHolder =
		ViewHolder(createView(viewGroup))

	private fun createView(viewGroup: ViewGroup) =
		viewGroup
			.context
			.let { context ->
				ImageCardView(ContextThemeWrapper(context, R.style.ImageCardTheme))
					.apply {

						isFocusable = true
						isFocusableInTouchMode = true

						setMainImageDimensions(
							context.getDimensionPixelSizeRes(R.dimen.card_width),
							context.getDimensionPixelSizeRes(R.dimen.card_height)
						)
					}
			}

	override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) =
		(viewHolder as ViewHolder)
			.bind(item as LeanbackCardItem)

	override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) =
		(viewHolder as ViewHolder)
			.unbind()

	private inner class ViewHolder(view: ImageCardView) : Presenter.ViewHolder(view) {
		private var requestManager: RequestManager? = null

		private val imageTarget = object : CustomViewTarget<View, Drawable>(view) {
			override fun onLoadFailed(errorDrawable: Drawable?) {}

			override fun onResourceCleared(placeholder: Drawable?) {}

			override fun onResourceReady(
				resource: Drawable,
				transition: Transition<in Drawable>?
			) {
				view.mainImage = resource
			}

		}

		fun bind(item: LeanbackCardItem) = with(view as ImageCardView) {
			item.run {
				requestManager = Glide.with(view)
				requestManager
					?.load(image)
					?.into(imageTarget)
				titleText = title
				contentText = content
				badgeImage = context.getDrawable(badgeIcon)
			}
		}

		fun unbind() = with(view as ImageCardView) {
			requestManager?.clear(imageTarget)
			mainImage = null
			badgeImage = null
			titleText = ""
			contentDescription = ""
		}

	}

}