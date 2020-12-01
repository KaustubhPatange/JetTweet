package com.kpstv.jettweet.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kpstv.jettweet.ui.utils.Screen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _eventsChannel = Channel<MainEvent>()
    val events = _eventsChannel.receiveAsFlow()

    fun openDrawer() = viewModelScope.launch {
        _eventsChannel.send(MainEvent.OPEN_DRAWER)
    }
}

enum class MainEvent {
    OPEN_DRAWER,
    NONE
}