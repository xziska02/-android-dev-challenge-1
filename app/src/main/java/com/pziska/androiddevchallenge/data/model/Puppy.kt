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
package com.pziska.androiddevchallenge.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Puppy(
    val name: String,
    val imageUrl: String,
    val breath: Breath,
    val about: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam consequat lacus porttitor malesuada egestas. Curabitur ac malesuada eros. Sed pulvinar dictum tincidunt. Nunc vehicula rutrum pellentesque. Nullam egestas massa quam, at tempor magna sodales non. Vivamus luctus sapien ut odio hendrerit mollis. Nulla elementum nisl est. Ut eu sodales sapien, at dignissim nisi. Nam sodales consequat massa, sed facilisis leo varius pulvinar.",
)
