package fm.finch.tv_test_project.browse

import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ObjectAdapter

class GridListRow(
    header: HeaderItem,
    adapter: ObjectAdapter,
    val numRows: Int = 1
) : ListRow(
    header,
    adapter
)