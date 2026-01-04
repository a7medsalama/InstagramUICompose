package com.ahmed.salama.instagramuicompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ReelScreen(
    image: Int?,
    accountName: String?,
    onBackClick: () -> Unit
) {
    val drawableId = image!!
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ScreenImage(
            imageUrl = drawableId,
            modifier = Modifier.fillMaxSize()
        )
        TopStatusBar(
            onBackClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        )
        FollowingLayout(
            accountName = accountName!!,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .navigationBarsPadding()
        )
    }
}

@Composable
fun ScreenImage(modifier: Modifier = Modifier, imageUrl: Int) {
    Image(
        painter = painterResource(imageUrl),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = modifier
    )
}

@Composable
fun TopStatusBar(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Box(
        modifier = modifier
            .height(90.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.80f),
                        Color.Transparent
                    )
                )
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()

        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .padding(start = 12.dp, top = 16.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = 0.25f))
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun FollowingLayout(modifier: Modifier = Modifier, accountName: String) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.80f)
                    )
                )
            )
            .padding(bottom = 26.dp)
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = accountName,
                color = Color.White,
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            FollowButton()
        }

    }
}

@Composable
fun FollowButton( followed: Boolean = false) {
    var followed by remember {
        mutableStateOf(followed)
    }
    OutlinedButton(
        onClick = {
            followed = !followed
        },
        border = BorderStroke(1.dp, Color.White),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Black.copy(alpha = 0.25f),
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
        Text(
            text = if (followed) "Followed" else "Following",
            color = Color.White,
        )
    }
}