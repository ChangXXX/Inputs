package chang.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCoroutineAndroid() {
    configureCoroutineKotlin()

    val libs = versionCatalog
    dependencies {
        add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
    }
}