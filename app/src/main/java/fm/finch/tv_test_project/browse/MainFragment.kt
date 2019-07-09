package fm.finch.tv_test_project.browse

import android.os.Bundle
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.SearchOrbView
import fm.finch.tv_test_project.R
import fm.finch.tv_test_project.extensions.getColorRes
import fm.finch.tv_test_project.extensions.getDrawableRes


class MainFragment : BrowseSupportFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {
        context?.let { context ->
            title = "Finch"
            badgeDrawable = context.getDrawableRes(R.drawable.app_icon_your_company)
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
