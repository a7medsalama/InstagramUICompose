package com.ahmed.salama.instagramuicompose

import android.R.attr.fontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.height(28.dp))
        TopBar(
            accountName = "ahmed.salama_official",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileStat(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        ProfileDescription(
            displayName = "Ahmed Salama",
            description = "Android Developer with 2 years of experience \n" +
                    "Want to make your app send me an email? \n" +
                    "and go take a look on my portfolio",
            url = "https://ahmed_salama_official.com",
            followedBy = listOf("mark_zuckerberg", "elon_musk_official"),
            otherCount = 7
        )
    }
    
}

//-----------------------------------------------

@Composable
fun TopBar(accountName: String,modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "image",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = accountName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Icon(
            painter = painterResource(R.drawable.icon_notification),
            contentDescription = "image",
            tint = Color.Black,
            modifier = Modifier.size(26.dp)
        )
        Icon(
            painter = painterResource(R.drawable.icon_menu),
            contentDescription = "image",
            tint = Color.Black,
            modifier = Modifier.size(26.dp)
        )
    }
}

@Composable
fun ProfileStat(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RoundImage(
            imageUrl = R.drawable.samurai_2,
            contentDes = "profile_image",
            modifier = Modifier
                .size(100.dp)
                .weight(3f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        StatSection(modifier = Modifier.weight(7f))

    }

}

@Composable
fun StatSection(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        ProfileStat("Posts", "200")
        ProfileStat("Followers", "10K")
        ProfileStat("Following", "100")
    }
}

@Composable
fun ProfileStat(
    title: String,
    value: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = title,
            fontWeight = FontWeight.W500,
            fontSize = 16.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun RoundImage(imageUrl: Int, contentDes: String, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(imageUrl),
        contentDescription = contentDes,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .padding(4.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .clip(CircleShape)
    )
    
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            color = Color.DarkGray,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            fontSize = 16.sp,
            textDecoration = TextDecoration.Underline,
            color = Color(0xFF199BD9),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            val boldStyle = SpanStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = buildAnnotatedString {
                    append("Followed by ")
                    followedBy.forEachIndexed { index,follower ->
                        pushStyle(boldStyle)
                        append(follower)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }

                }
            )
        }
    }
}