package com.workshopkotlin.myapplication

import android.app.Application
import com.workshopkotlin.myapplication.data.sharedpref.SharedprefUtil

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        SharedprefUtil.init(this)
    }
}