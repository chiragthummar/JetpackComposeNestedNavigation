package com.cb.jetpackcomposenestednavigation

sealed class Screens(val route : String) {

    object Dashboard : Screens("dashboard")

    object Home : Screens("home"){
        object Login : Screens("login")
        object Register : Screens("register")
    }
}