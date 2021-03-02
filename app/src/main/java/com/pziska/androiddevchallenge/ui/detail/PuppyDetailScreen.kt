package com.pziska.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pziska.androiddevchallenge.R
import com.pziska.androiddevchallenge.data.model.Puppy
import com.pziska.androiddevchallenge.ui.theme.shapes
import com.pziska.androiddevchallenge.ui.theme.typography
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun PuppyDetailScreen(puppy: Puppy, upAction: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier
                .height(250.dp)
                .width(250.dp)
                .fillMaxWidth()
                .clip(CircleShape), elevation = 8.dp
        ) {
            CoilImage(
                data = puppy.imageUrl,
                contentDescription = "${puppy.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(Modifier.fillMaxWidth()) {
                        CircularProgressIndicator(
                            Modifier.align(Alignment.Center),
                            color = MaterialTheme.colors.onSurface
                        )
                    }
                }
            )
        }

        Text(
            text = puppy.name,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            style = TextStyle(fontSize = 20.sp)
        )
        Text(text = puppy.about, style = TextStyle(fontSize = 14.sp), )
    }

    Button(
        onClick = upAction,
        shape = shapes.large,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
        modifier = Modifier
            .padding(16.dp)
            .width(48.dp)
            .height(48.dp),

        ) {
        Image(painter = painterResource(R.drawable.ic_back), contentDescription = null)
    }
}