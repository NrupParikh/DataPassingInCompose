package com.nrup.datapassingincompose.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nrup.datapassingincompose.R
import com.nrup.datapassingincompose.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {

    val textFieldValue = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.title_first_screen),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.padding(8.dp))

        TextField(
            value = textFieldValue.value,
            onValueChange = { newText ->
                textFieldValue.value = newText
            },
            singleLine = true,
            modifier = Modifier.width(300.dp),
            label = {
                Text(text = stringResource(id = R.string.hint_enter_value))
            }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Button(onClick = {
            //second_screen/ABCD
            navController.navigate(route = Routes.getSecondScreenPath(textFieldValue.value.text))
        }) {
            Text(text = stringResource(id = R.string.go_to_second_screen))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LightPreviewFirstScreen() {
    FirstScreen(navController = NavController(LocalContext.current))
}


@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun DarkPreviewFirstScreen() {
    FirstScreen(navController = NavController(LocalContext.current))
}