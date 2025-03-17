package com.example.sus_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // Optimized import
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.example.sus_project.ui.theme.Sus_projectTheme
import androidx.compose.runtime.*
import com.example.sus_project.utils.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

//Initialization of app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //Setup of transparent navigation bar
        transparentNavBar()
        super.onCreate(savedInstanceState)
        setContent {
            //Theme applied to the app
            Sus_projectTheme {
                Main()
            }
        }
    }
}

//The app components together
@Composable
fun Main() {
    var isPermissionGranted by remember { mutableStateOf(false) }
    RequestLocationPermissionUsingRememberLauncherForActivityResult(
        onPermissionGranted = { isPermissionGranted = true },
        onPermissionDenied = { isPermissionGranted = false }
    )

    Surface(Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize().padding(bottom = 80.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TopBar()
                LocationFeature(isPermissionGranted)
            }
        }

    }
}

@Preview
@Composable
fun MainPreview() {
    Main()
}
