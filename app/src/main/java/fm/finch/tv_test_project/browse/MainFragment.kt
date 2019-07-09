package fm.finch.tv_test_project.browse

import android.os.Bundle
import androidx.leanback.app.BrowseSupportFragment


class MainFragment : BrowseSupportFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {
        title = "Finch"
    }

}
