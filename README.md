## Data Passing In Compose

- MainActivity contains NavHost and has three composable components.
  - FirstScreen is Start Destination.Has a Text Field to send data to SecondScreen in Argument
  - SecondScreen : Get FirstScreen value and show on Text composable. Button to navigate ThirdScreen
  - ThirdScreen : Has button to navigate SecondScreen and FirstScreen directly by removing stack.
- In this demo, Every composable component has Shared View Model
- We set value from Third Screen and get that value in First Screen using Shared View Model

## Video of my work

[Nrup_data_passing_in_compose.webm](https://github.com/NrupParikh/DataPassingInCompose/assets/108717119/f9d11adf-dd72-4c94-9c2b-1e5211e13f04)

## Useful methods

- navController.navigate("routeName") : Navigate to particular screen
- navController.popBackStack() : Go to Back screen
- navController.popBackStack("routeName",inclusiveTrueOrFalse) : Go back upTo specified route
- arguments = listOf(navArgument(Routes.Values.SCREEN_VALUE) { type = NavType.StringType }) : send data in argument
- backStackEntry.arguments?.getString("routeName/key","defaultValue") : get data from argument


## References

https://tomas-repcik.medium.com/android-jetpack-compose-and-navigation-59f5ffa1219e
