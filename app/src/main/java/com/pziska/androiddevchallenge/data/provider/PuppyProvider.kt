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
package com.pziska.androiddevchallenge.data.provider

import com.pziska.androiddevchallenge.data.model.Breath
import com.pziska.androiddevchallenge.data.model.Puppy

object PuppyProvider {
    fun getPuppyList() = listOf(
        Puppy(
            "Honey",
            "https://placedog.net/250/250",
            Breath.Dog,
        ),
        Puppy(
            "Barney",
            "https://placedog.net/300/300",
            Breath.Dog,
        ),
        Puppy(
            "Joey",
            "https://placedog.net/400/400",
            Breath.Dog,
        ),
        Puppy(
            "Freddie",
            "https://placedog.net/500/500",
            Breath.Dog,
        ),
        Puppy(
            "Name",
            "https://placedog.net/600/600",
            Breath.Dog,
        ),
        Puppy(
            "Muro",
            "https://placekitten.com/250/250",
            Breath.Cat,
        ),
        Puppy(
            "Maria",
            "https://placekitten.com/300/300",
            Breath.Cat,
        )
    )
}
