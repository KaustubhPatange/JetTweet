package com.kpstv.jettweet.ui.search

import androidx.compose.runtime.Composable
import com.kpstv.jettweet.R
import com.kpstv.jettweet.ui.AbstractFragment

class SearchFragment : AbstractFragment(R.id.search_fragment) {
    @Composable
    override fun content() {
        Search(
            onNavClick = { mainViewModel.openDrawer() }
        )
    }
}