package com.pziska.androiddevchallenge.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Puppy(
    val name: String,
    val imageUrl: String,
    val breath: Breath,
    val about: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam consequat lacus porttitor malesuada egestas. Curabitur ac malesuada eros. Sed pulvinar dictum tincidunt. Nunc vehicula rutrum pellentesque. Nullam egestas massa quam, at tempor magna sodales non. Vivamus luctus sapien ut odio hendrerit mollis. Nulla elementum nisl est. Ut eu sodales sapien, at dignissim nisi. Nam sodales consequat massa, sed facilisis leo varius pulvinar.",
)
