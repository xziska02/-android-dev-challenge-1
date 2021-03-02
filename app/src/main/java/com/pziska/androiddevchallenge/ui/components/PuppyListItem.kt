package com.pziska.androiddevchallenge.ui.components

import androidx.cardview.widget.CardView
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.pziska.androiddevchallenge.data.model.Puppy
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.pziska.androiddevchallenge.ui.theme.shapes
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyListItem(puppy: Puppy, onClick: (Puppy) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(puppy) }
            .fillMaxWidth()
            .clip(shape = shapes.large),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Card(shape = shapes.medium) {
                CoilImage(
                    data = puppy.imageUrl,
                    contentDescription = "${puppy.name}",
                    modifier = Modifier
                        .height(120.dp)
                        .width(120.dp)
                        .fillMaxWidth()
                        .clip(shape = shapes.large),
                    contentScale = ContentScale.Fit,
                    loading = {
                        Box(Modifier.fillMaxWidth()) {
                            CircularProgressIndicator(
                                Modifier.align(Alignment.Center),
                                color = Color.White
                            )
                        }
                    }
                )
            }

        }
        Column(modifier = Modifier
            .padding(8.dp)
            .alignByBaseline()) {
            Text(text = puppy.name, style = TextStyle(fontSize = 20.sp))
            Text(text = puppy.about, style = TextStyle(fontSize = 14.sp), maxLines = 3)
        }
    }
}
