package com.kpstv.jettweet

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.kpstv.jettweet.ui.MainEvent
import com.kpstv.jettweet.ui.MainViewModel
import com.kpstv.jettweet.ui.custom.JetTweetDivider
import com.kpstv.jettweet.ui.custom.JetTweetDrawer
import com.kpstv.jettweet.ui.theme.JetTweetTheme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Suppress("RemoveExplicitTypeArguments")
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()

    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNav.setupWithNavController(navController)

        findViewById<ComposeView>(R.id.compose_view).setContent {
            JetTweetTheme {
                JetTweetDivider()
            }
        }

        findViewById<ComposeView>(R.id.drawer_compose).setContent {
            JetTweetDrawer()
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            viewModel.events.collect { event ->
                when (event) {
                    MainEvent.OPEN_DRAWER -> {
                        drawer.openDrawer(GravityCompat.START)
                    }
                    MainEvent.NONE -> {
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if (drawer.isOpen) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
