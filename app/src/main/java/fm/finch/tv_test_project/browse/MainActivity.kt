package fm.finch.tv_test_project.browse

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import fm.finch.tv_test_project.R.layout

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }
}
