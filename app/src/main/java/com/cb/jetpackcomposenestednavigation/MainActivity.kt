package com.cb.jetpackcomposenestednavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.cb.jetpackcomposenestednavigation.ui.theme.JetpackComposeNestedNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeNestedNavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NestedNavigationExample()
                }
            }
        }
    }
}

@Composable
fun NestedNavigationExample() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {

        navigation(
            startDestination = Screens.Home.Login.route,
            route = Screens.Home.route
        ) {
            composable(route = Screens.Home.Login.route) {
                LoginScreen {
                    navController.navigate(it)
                }
            }
            composable(route = Screens.Home.Register.route) {
                RegisterScreen {
                    navController.navigate(it)
                }
            }
        }

        composable(route = Screens.Dashboard.route) {
            DashboardScreen {
                navController.navigate(it)

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navigateTo: (route: String) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Dashboard") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
        )
    }) {
        Box(
            Modifier
                .padding(it)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = "Dashboard Screen Content")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navigateTo: (route: String) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Login") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
        )
    }) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                navigateTo(Screens.Dashboard.route)
            }) {
                Text(text = "Login")
            }
            Button(onClick = {
                navigateTo(Screens.Home.Register.route)
            }) {
                Text(text = "Register")
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navigateTo: (route: String) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Register") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
        )
    }) {
        Box(
            Modifier
                .padding(it)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                navigateTo(Screens.Dashboard.route)
            }) {
                Text(text = "Register")
            }
        }
    }
}


