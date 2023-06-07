# Data Passing InCompose

- MainActivity contains NavHost and has three composable components.
  - FirstScreen is Start Destination.Has a Text Field to send data to SecondScreen in Argument
  - SecondScreen : Get FirstScreen value and show on Text composable. Button to navigate ThirdScreen
  - ThirdScreen : Has button to navigate SecondScreen and FirstScreen directly by removing stack.

# Useful methods

- navController.navigate("routeName") : Navigate to particular screen
- navController.popBackStack() : Go to Back screen
- navController.popBackStack("routeName",inclusiveTrueOrFalse) : Go back upTo specified route
- arguments = listOf(navArgument(Routes.Values.SCREEN_VALUE) { type = NavType.StringType }) : send data in argument
- backStackEntry.arguments?.getString("routeName/key","defaultValue") : get data from argument
