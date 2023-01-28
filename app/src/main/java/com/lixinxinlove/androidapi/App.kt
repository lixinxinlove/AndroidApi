package com.lixinxinlove.androidapi

import android.app.Application
import com.lixinxinlove.androidapi.executor.LiveExecutor
import timber.log.Timber


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this


        LiveExecutor.start()


        if (BuildConfig.DEBUG) {
            // default logging
           Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var application: Application
    }
}