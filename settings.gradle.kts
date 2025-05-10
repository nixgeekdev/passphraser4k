@file:Suppress("UnstableApiUsage")

rootProject.name = "passphraser4k"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}

plugins {
    id("com.gradle.develocity") version "4.0.1"
}

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/terms-of-service"
        termsOfUseAgree = "yes"
        publishing.onlyIf {
            providers.environmentVariable("GITHUB_ACTIONS").isPresent
        }
    }
}

rootDir.listFiles()?.filter {
    File(it, "build.gradle.kts").exists() &&
            !it.name.contains("build-logic")
}?.forEach {
    logger.lifecycle("> Including project :${it.name}")
    include(it.name)
}
