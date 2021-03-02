package com.pziska.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pziska.androiddevchallenge.data.model.Puppy

@Composable
fun PuppyList(puppies: List<Puppy>, modifier: Modifier, onClick: (Puppy) -> Unit) {
    Box(modifier = modifier) {
        LazyColumn(Modifier.fillMaxWidth()) {
            items(puppies) { puppy ->
                PuppyListItem(puppy = puppy, onClick = onClick)
            }
        }
    }
}