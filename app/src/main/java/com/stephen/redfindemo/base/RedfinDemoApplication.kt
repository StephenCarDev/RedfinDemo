package com.stephen.redfindemo.base

import android.app.Application

class RedfinDemoApplication : Application() {

    companion object {
        lateinit var instance: Application
    }

    init {
        instance = this
    }


}