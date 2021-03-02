/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pziska.androiddevchallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pziska.androiddevchallenge.data.model.Puppy
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
        Column(
            modifier = Modifier
                .padding(8.dp)
                .alignByBaseline()
        ) {
            Text(text = puppy.name, style = TextStyle(fontSize = 20.sp))
            Text(text = puppy.about, style = TextStyle(fontSize = 14.sp), maxLines = 3)
        }
    }
}
