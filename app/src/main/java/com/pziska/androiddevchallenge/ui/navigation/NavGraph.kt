package com.pziska.androiddevchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
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
            "${PUPPY_DETAIL}/{$KEY_PUPPY}",
            arguments = listOf(navArgument(KEY_PUPPY) {
                type = NavType.StringType
            })
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