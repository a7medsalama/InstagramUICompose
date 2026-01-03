package com.ahmed.salama.instagramuicompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

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
                    "Want to make your app send me an email?",
            url = "https://ahmed_salama_official.com",
            followedBy = listOf("mark_zuckerberg", "elon_musk_official"),
            otherCount = 7
        )
        Spacer(modifier = Modifier.height(20.dp))
        ButtonsSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))
        StoryHighlights(
            reels = listOf(
                ImageWithText(
                    text = "Reels",
                    image = painterResource(id = R.drawable.samurai_1)
                ),
                ImageWithText(
                    text = "Reels",
                    image = painterResource(id = R.drawable.samurai_2)
                ),
                ImageWithText(
                    text = "Reels",
                    image = painterResource(id = R.drawable.samurai_2)
                ),
                ImageWithText(
                    text = "Reels",
                    image = painterResource(id = R.drawable.samurai_2)
                ),
                ImageWithText(
                    text = "Reels",
                    image = painterResource(id = R.drawable.samurai_2)
                ),
                ImageWithText(
                    text = "Reels",
                    image = painterResource(id = R.drawable.samurai_1)
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)

        )
        Spacer(modifier = Modifier.height(16.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageWithText(
                    text = "Posts",
                    image = painterResource(id = R.drawable.icon_posts)
                ),
                ImageWithText(
                    text = "Reels",
                    image = painterResource(id = R.drawable.icon_reels)
                ),
                ImageWithText(
                    text = "Videos",
                    image = painterResource(id = R.drawable.icon_video)
                ),
                ImageWithText(
                    text = "Shop",
                    image = painterResource(id = R.drawable.icon_bag)
                )
            )
        ) {
            selectedTabIndex = it
        }
        Spacer(modifier = Modifier.height(6.dp))
        if (selectedTabIndex == 0) {
            PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.samurai_1),
                    painterResource(id = R.drawable.samurai_2),
                    painterResource(id = R.drawable.samurai_3),
                    painterResource(id = R.drawable.samurai_6),
                    painterResource(id = R.drawable.samurai_5),
                    painterResource(id = R.drawable.samurai_6),
                )
            )
        }
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
            imageUrl = painterResource(R.drawable.samurai_2),
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
fun RoundImage(imageUrl: Painter, contentDes: String?, modifier: Modifier = Modifier) {
    Image(
        painter = imageUrl,
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
    val lineHeight = 15.sp

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
                ,
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun ButtonsSection(modifier: Modifier = Modifier) {
    val minWidth = 98.dp
    val staticHeight = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(staticHeight)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(staticHeight)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(staticHeight)
        )
        ActionButton(
            icon= Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(staticHeight)
        )
    }
}

@Composable
fun StoryHighlights(
    modifier: Modifier = Modifier,
    reels: List<ImageWithText>
) {
    LazyRow(
        modifier = modifier
    ) {
        items(reels.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(end = 12.dp)
            ) {
                RoundImage(
                    imageUrl = reels[it].image,
                    contentDes = null,
                    modifier = Modifier
                        .size(70.dp)
                )
                Text(
                    text = reels[it].text,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W600,
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(0) }
    val inactiveColor = Color(0xFF777777)
    val activeColor = Color.Black

    TabRow(
        selectedTabIndex = selectedIndex,
        containerColor = Color.Transparent,
        contentColor = activeColor,
        modifier = modifier.background(Color.Transparent),
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedIndex])
                    .height(3.dp),
                color = activeColor // underline color
            )
        },
        divider = { } // remove the gray divider line
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedIndex == index) activeColor else inactiveColor,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(8.dp)
                )
            }
        }
    }
}


@Composable
fun PostSection(modifier: Modifier = Modifier, posts: List<Painter>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}