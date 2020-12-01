package com.kpstv.jettweet.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.semantics.accessibilityLabel
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.kpstv.jettweet.ui.theme.JetTweetTheme
import com.kpstv.jettweet.ui.utils.Screen

@Composable
fun JetTweetAppBar(
    modifier: Modifier = Modifier,
    screen: Screen,
    onNavigationClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Providers(AmbientContentColor provides MaterialTheme.colors.secondary) {
            Row(
                modifier = Modifier.background(MaterialTheme.colors.primary).fillMaxWidth()
                    .height(56.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onNavigationClick) {
                    Icon(asset = Icons.Outlined.Dehaze)
                }
                content()
                if (screen == Screen.HOME) {
                    IconButton(onClick = {}) {
                        Icon(asset = Icons.Outlined.FilterVintage)
                    }
                } else {
                    IconButton(onClick = {}) {
                        Icon(asset = Icons.Outlined.Settings)
                    }
                }
            }
        }
        JetTweetDivider()
    }
}

@Composable
fun JetTweetDivider(modifier: Modifier = Modifier) {
        Divider()
}