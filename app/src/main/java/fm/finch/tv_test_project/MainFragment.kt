package fm.finch.tv_test_project

import android.os.Bundle
import android.support.v17.leanback.app.BrowseSupportFragment
import android.support.v17.leanback.widget.SearchOrbView
import android.support.v4.content.ContextCompat
import fm.finch.tv_test_project.extensions.getColorRes

class MainFragment : BrowseSupportFragment() {

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		initView(savedInstanceState)
	}

	private fun initView(savedInstanceState: Bundle?) {
		context?.let { context ->
			title = "FinchFinchFinchFinchFinchFinchFinchFinchFinch"
			badgeDrawable = ContextCompat.getDrawable(context, R.drawable.app_icon_your_company)
			searchAffordanceColor = context.getColorRes(R.color.search_opaque)
			searchAffordanceColors = SearchOrbView.Colors(
				context.getColorRes(R.color.search_opaque),
				context.getColorRes(R.color.search_opaque_bright),
				context.getColorRes(R.color.search_opaque_icon)
			)
		}


		setOnSearchClickedListener {

		}

	}



}
