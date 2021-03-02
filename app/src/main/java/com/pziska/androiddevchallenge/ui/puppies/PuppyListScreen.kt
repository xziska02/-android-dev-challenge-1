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

@Composable
fun PuppyListScreen(action: (Puppy) -> Unit, puppyListViewModel: PuppyListViewModel = viewModel()) {
    val puppies by puppyListViewModel.puppies.observeAsState(emptyList())

    PuppyList(
        puppies = puppies, modifier = Modifier.fillMaxWidth(),
        onClick = {
            Log.e("TAG", "-- Select: ${it.name}")
            action(it)
        }
    )
}
