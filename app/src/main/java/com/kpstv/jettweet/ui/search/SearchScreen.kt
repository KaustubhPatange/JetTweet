package com.kpstv.jettweet.ui.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.kpstv.jettweet.R
import com.kpstv.jettweet.ui.custom.JetTweetAppBar
import com.kpstv.jettweet.ui.theme.JetTweetTheme
import com.kpstv.jettweet.ui.utils.Screen

@Composable
fun Search(onNavClick: () -> Unit) {
    JetTweetTheme {
        Scaffold(
            topBar = {
                JetTweetAppBar(
                    screen = Screen.SEARCH,
                    onNavigationClick = onNavClick,
                    content = {

                    }
                )
            },
            bodyContent = {

            }
        )
    }
}