package com.kpstv.jettweet.ui.home

import androidx.compose.runtime.Composable
import com.kpstv.jettweet.R
import com.kpstv.jettweet.ui.AbstractFragment

class HomeFragment : AbstractFragment(R.id.home_fragment) {
    @Composable
    override fun content() {
        Home(onNavClick = { mainViewModel.openDrawer() })
    }
}