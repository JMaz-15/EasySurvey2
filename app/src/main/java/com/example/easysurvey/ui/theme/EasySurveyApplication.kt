package com.example.easysurvey.ui.theme

import com.google.firebase.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class EasySurveyApplication {
    fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@EasySurveyApplication)
            modules(appModule)
        }
}
}
