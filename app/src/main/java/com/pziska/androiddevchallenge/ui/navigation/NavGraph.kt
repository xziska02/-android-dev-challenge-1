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
package com.pziska.androiddevchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.pziska.androiddevchallenge.data.model.Puppy
import com.pziska.androiddevchallenge.ui.detail.PuppyDetailScreen
import com.pziska.androiddevchallenge.ui.navigation.MainDestinations.KEY_PUPPY
import com.pziska.androiddevchallenge.ui.navigation.MainDestinations.PUPPY_DETAIL
import com.pziska.androiddevchallenge.ui.navigation.MainDestinations.PUPPY_LIST
import com.pziska.androiddevchallenge.ui.puppies.PuppyListScreen
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object MainDestinations {
    const val PUPPY_DETAIL = "puppy"
    const val PUPPY_LIST = "puppy_list"
    const val KEY_PUPPY = "key_puppy"
}

@Composable
fun NavGraph(startDestination: String = PUPPY_LIST) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }
    NavHost(navController, startDestination) {
        composable(
            "$PUPPY_DETAIL/{$KEY_PUPPY}",
            arguments = listOf(
                navArgument(KEY_PUPPY) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val puppyString = requireNotNull(arguments.getString(KEY_PUPPY))
            val puppy = Json.decodeFromString<Puppy>(puppyString)
            PuppyDetailScreen(puppy = puppy, actions.upPress)
        }

        composable(PUPPY_LIST) {
            PuppyListScreen(actions.selectPuppy)
        }
    }
}

class MainActions(navController: NavController) {
    val selectPuppy: (Puppy) -> Unit = {
        val puppyString = Json.encodeToString(it)
        navController.navigate("$PUPPY_DETAIL/$puppyString")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
