package fm.finch.tv_test_project.browse.customTitle

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.leanback.widget.TitleViewAdapter
import fm.finch.tv_test_project.R.layout
import kotlinx.android.synthetic.main.view_custom_title.view.vTitle

class CustomTitleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), TitleViewAdapter.Provider {

    private val titleViewAdapter = object : TitleViewAdapter() {
        override fun getSearchAffordanceView(): View? {
            return null
        }

        override fun setTitle(titleText: CharSequence?) {
            this@CustomTitleView.setTitle(titleText)
        }
    }


    init {
        View.inflate(context, layout.view_custom_title, this)
    }

    private fun setTitle(title: CharSequence?) {
        vTitle.text = title
    }

    override fun getTitleViewAdapter(): TitleViewAdapter {
        return titleViewAdapter
    }
}