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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pziska.androiddevchallenge.data.model.Puppy
import com.pziska.androiddevchallenge.data.provider.PuppyProvider

class PuppyListViewModel : ViewModel() {

    private val _puppies: MutableLiveData<List<Puppy>> = MutableLiveData(emptyList())
    val puppies: LiveData<List<Puppy>> = _puppies

    init {
        _puppies.postValue(PuppyProvider.getPuppyList())
    }
}
