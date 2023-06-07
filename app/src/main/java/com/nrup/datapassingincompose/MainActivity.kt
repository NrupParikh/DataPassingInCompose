package com.nrup.datapassingincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nrup.datapassingincompose.composables.FirstScreen
import com.nrup.datapassingincompose.composables.SecondScreen
import com.nrup.datapassingincompose.composables.ThirdScreen
import com.nrup.datapassingincompose.ui.theme.DataPassingInComposeTheme
import com.nrup.datapassingincompose.utils.Routes
import com.nrup.datapassingincompose.viewmodel.MySharedVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataPassingInComposeTheme {

                val viewModel = MySharedVM()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Routes.FIRST_SCREEN) {
                        composable(route = Routes.FIRST_SCREEN) {
                            FirstScreen(
                                navController = navController,
                                sharedVM = viewModel
                            )
                        }


                        composable(
                            route = Routes.SECOND_SCREEN,
                            arguments = listOf(
                                navArgument(Routes.Values.SCREEN_VALUE) {
                                    type = NavType.StringType
                                })
                        ) { backStackEntry ->
                            SecondScreen(
                                navController = navController,
                                myContent = backStackEntry.arguments?.getString(
                                    Routes.Values.SCREEN_VALUE, "Default value"
                                ),
                                sharedVM = viewModel
                            )
                        }

                        composable(route = Routes.THIRD_SCREEN) {
                            ThirdScreen(
                                navController = navController,
                                sharedVM = viewModel
                            )
                        }
                    }
                }
            }
        }
    }
}