pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "inputs"
include(":app")
include(":core:designsystem")
include(":core:navigation")
include(":feature:note")
include(":feature:write")
include(":feature:notedetail")
include(":feature:main")
include(":feature:favorites")
include(":core:androidutil")
