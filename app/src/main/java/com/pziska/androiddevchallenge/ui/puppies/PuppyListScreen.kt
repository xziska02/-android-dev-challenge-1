package com.pziska.androiddevchallenge.ui.puppies

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pziska.androiddevchallenge.data.model.Puppy
import com.pziska.androiddevchallenge.ui.components.PuppyList
import com.pziska.androiddevchallenge.ui.puppies.PuppyListViewModel

@Composable
fun PuppyListScreen(action: (Puppy)-> Unit, puppyListViewModel: PuppyListViewModel = viewModel()) {
    val puppies by puppyListViewModel.puppies.observeAsState(emptyList())

    PuppyList(puppies = puppies, modifier = Modifier.fillMaxWidth(), onClick = {
        Log.e("TAG", "-- Select: ${it.name}")
        action(it)
    })
}