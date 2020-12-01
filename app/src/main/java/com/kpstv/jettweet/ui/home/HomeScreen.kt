package com.kpstv.jettweet.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.android.material.theme.overlay.MaterialThemeOverlay
import com.kpstv.jettweet.R
import com.kpstv.jettweet.ui.custom.JetTweetAppBar
import com.kpstv.jettweet.ui.theme.JetTweetTheme
import com.kpstv.jettweet.ui.utils.Screen

@Composable
fun Home(onNavClick: () -> Unit) {
    // TODO: Add small chat head at top pinned below App bar.

    // TODO: Add fab button & animate if state is different, see twitter
    //       how it rotates when & from Home screen.
    JetTweetTheme {
        Scaffold(
            topBar = {
                JetTweetAppBar(
                    screen = Screen.HOME,
                    onNavigationClick = onNavClick,
                    content = {
                        Icon(
                            modifier = Modifier.padding(13.dp),
                            asset = vectorResource(R.drawable.twitter_logo),
                            tint = MaterialTheme.colors.secondary
                        )
                    }
                )
            },
            bodyContent = {
                ChatItem()
                // TODO: Create some fake datas & add more chat item
            }
        )
    }
}

@Composable
fun ChatItem(modifier: Modifier = Modifier) {
    // TODO: Make the chat Item contain the vertical bars like one when someone
    //       replied to other people
    ConstraintLayout(modifier.fillMaxWidth().padding(12.dp)) {
        val (profile, heading, tag, icon, text, actions) = createRefs()
        Image(
            asset = imageResource(R.drawable.profile),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .preferredSize(60.dp)
                .clip(CircleShape)
                .constrainAs(profile) {
                    start.linkTo(parent.start)
                }
        )
        Text(
            text = "Iheb AB",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .padding(start = 10.dp)
                .constrainAs(heading) {
                    start.linkTo(profile.end)
                }
        )
        Providers(AmbientContentAlpha provides ContentAlpha.medium) {
            Text(
                text = "@iheabAB · 3h",
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .padding(start = 7.dp)
                    .constrainAs(tag) {
                        start.linkTo(heading.end)
                    }
            )
            Icon(
                asset = Icons.Outlined.KeyboardArrowDown,
                modifier = Modifier
                    .constrainAs(icon) {
                        end.linkTo(parent.end)
                    }
            )
        }
        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .padding(start = 10.dp)
                .constrainAs(text) {
                    start.linkTo(profile.end)
                    top.linkTo(heading.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
        Providers(AmbientContentAlpha provides ContentAlpha.medium) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 10.dp, end = 40.dp, top = 10.dp)
                    .constrainAs(actions) {
                        top.linkTo(text.bottom)
                        start.linkTo(profile.end)
                        end.linkTo(icon.end)
                        width = Dimension.fillToConstraints
                    }
            ) {
                ChatActions(
                    icon = Icons.Outlined.ChatBubbleOutline,
                    number = 3
                )
                ChatActions(
                    icon = Icons.Outlined.Cached,
                    number = 6
                )
                // TODO: Make this Favourite item selectable & when selected
                //       show filled icon with color red or similar
                ChatActions(
                    icon = Icons.Outlined.FavoriteBorder,
                    number = 42
                )
                ChatActions(
                    icon = Icons.Outlined.Share
                )
            }
        }
    }
}

@Composable
fun ChatActions(icon: VectorAsset, number: Int? = null) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(asset = icon, modifier = Modifier.preferredSize(19.dp))
        if (number != null)
            Text(
                text = "$number",
                modifier = Modifier.padding(horizontal = 5.dp),
                style = MaterialTheme.typography.overline
            )
    }
}