import chang.app.configureCoroutineKotlin
import chang.app.configureKotlinJvm
import org.gradle.kotlin.dsl.dependencies

plugins {
    kotlin("jvm")
}

configureKotlinJvm()
configureCoroutineKotlin()