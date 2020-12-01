package com.kpstv.jettweet.ui.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableAmbient
import androidx.compose.runtime.Providers
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kpstv.jettweet.R
import com.kpstv.jettweet.ui.theme.JetTweetTheme

@Composable
fun JetTweetDrawer() {
    JetTweetTheme {
        Surface {
            Column {
                AuthorProfileAndDetails()
                Spacer(modifier = Modifier.preferredHeight(5.dp))
                JetTweetDivider()
                DrawerMenu()
                Spacer(modifier = Modifier.weight(1f))
                JetTweetDivider()
                BottomBar(AmbientContentColor)
            }
        }
    }
}

@Composable
fun AuthorProfileAndDetails() {
    Column(modifier = Modifier.padding(horizontal = 23.dp, vertical = 15.dp)) {
        Image(
            asset = imageResource(R.drawable.profile),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 25.dp)
                .preferredSize(60.dp)
                .clip(CircleShape)
        )
        Spacer(Modifier.preferredHeight(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Author name",
                style = MaterialTheme.typography.h5
            )
            Icon(
                asset = Icons.Outlined.KeyboardArrowDown,
                tint = MaterialTheme.colors.secondary
            )
        }
        Providers(AmbientContentAlpha provides ContentAlpha.medium) {
            Text(
                text = "@author",
                style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Normal)
            )
            Spacer(Modifier.preferredHeight(12.dp))
            // Following
            val following = AnnotatedString(
                text = "45",
                spanStyle = SpanStyle(
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Bold
                )
            )
            // Followers
            val followers = AnnotatedString(
                text = "27",
                spanStyle = SpanStyle(
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Bold
                )
            )
            Row {
                Text(
                    text = annotatedString {
                        append(following)
                        append(" Following")
                    }
                )
                Spacer(modifier = Modifier.preferredWidth(10.dp))
                Text(
                    text = annotatedString {
                        append(followers)
                        append(" Followers")
                    }
                )
            }
        }
    }
}

@Composable
fun DrawerMenu() {
    Column {
        NavItem("Profile", Icons.Rounded.PersonOutline)
        NavItem("List", Icons.Rounded.Article)
        NavItem("Topics", Icons.Rounded.Chat)
        NavItem("Bookmarks", Icons.Rounded.BookmarkBorder)
        NavItem("Moments", Icons.Rounded.FlashOn)
        Spacer(modifier = Modifier.preferredHeight(10.dp))
        JetTweetDivider()
        Spacer(modifier = Modifier.preferredHeight(10.dp))
        NavItem(title = "Settings and privacy")
        NavItem(title = "Help Centre")
    }
}

@Composable
fun NavItem(title: String, icon: VectorAsset? = null, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .preferredHeight(55.dp)
            .clickable(onClick = onClick)
            .padding(horizontal = 23.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            Providers(AmbientContentAlpha provides ContentAlpha.medium) {
                Icon(asset = icon, modifier = Modifier.preferredHeight(40.dp))
            }
            Spacer(Modifier.preferredWidth(10.dp))
        }
        Text(
            text = title,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun BottomBar(AmbientContentColor: ProvidableAmbient<Color>) {
    Row(modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
        Providers(AmbientContentColor provides MaterialTheme.colors.secondary) {
            BottomItem(asset = Icons.Outlined.EmojiObjects)
            Spacer(modifier = Modifier.weight(1f))
            BottomItem(asset = Icons.Rounded.QrCode)
        }
    }
}

@Composable
fun BottomItem(asset: VectorAsset, onClick: () -> Unit = {}) {
    Icon(
        modifier = Modifier
            .clickable(onClick = onClick, indication = null),
        asset = asset,
    )
}