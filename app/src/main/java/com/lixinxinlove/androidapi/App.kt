package com.lixinxinlove.androidapi

import android.app.Application
import com.lixinxinlove.androidapi.executor.LiveExecutor
import com.lixinxinlove.androidapi.logger.Logger

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this


        LiveExecutor.start()
    }

    companion object {
        lateinit var application: Application
    }
}