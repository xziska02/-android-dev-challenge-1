package com.pziska.androiddevchallenge.data.provider

import com.pziska.androiddevchallenge.data.model.Breath
import com.pziska.androiddevchallenge.data.model.Puppy

object PuppyProvider {
    fun getPuppyList() = listOf(
        Puppy(
            "Honey",
            "https://placedog.net/250/250",
            Breath.Dog,
        ), Puppy(
            "Barney",
            "https://placedog.net/300/300",
            Breath.Dog,
        ), Puppy(
            "Joey",
            "https://placedog.net/400/400",
            Breath.Dog,
        ), Puppy(
            "Freddie",
            "https://placedog.net/500/500",
            Breath.Dog,
        ), Puppy(
            "Name",
            "https://placedog.net/600/600",
            Breath.Dog,
        ), Puppy(
            "Muro",
            "https://placekitten.com/250/250",
            Breath.Cat,
        ), Puppy(
            "Maria",
            "https://placekitten.com/300/300",
            Breath.Cat,
        )
    )
}