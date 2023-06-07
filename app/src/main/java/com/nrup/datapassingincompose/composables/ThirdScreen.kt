package com.nrup.datapassingincompose.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nrup.datapassingincompose.R
import com.nrup.datapassingincompose.utils.Routes

@Composable
fun ThirdScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.title_third_screen),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = stringResource(id = R.string.back_to_second_screen))
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Button(onClick = {
            // false means, it not remove the first_screen
            navController.popBackStack(Routes.FIRST_SCREEN, false)
        }) {
            Text(text = stringResource(id = R.string.back_to_first_screen))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LightPreviewThirdScreen() {
    ThirdScreen(navController = NavController(LocalContext.current))
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun DarkPreviewThirdScreen() {
    ThirdScreen(navController = NavController(LocalContext.current))
}