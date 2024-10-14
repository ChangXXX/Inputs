
import chang.app.configureComposeAndroid
import chang.app.configureHiltAndroid
import chang.app.configureKotlinAndroid

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureComposeAndroid()
configureHiltAndroid()
