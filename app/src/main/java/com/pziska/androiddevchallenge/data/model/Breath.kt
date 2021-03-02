package com.pziska.androiddevchallenge.data.model

import kotlinx.serialization.Serializable

@Serializable
sealed class Breath(val name: String) {
    @Serializable
    object Cat : Breath("Cat")

    @Serializable
    object Dog : Breath("Dog")
}
