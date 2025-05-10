import org.jetbrains.kotlin.gradle.dsl.KotlinBaseExtension

plugins {
    idea
    java
    kotlin("jvm") version libs.versions.kotlin.language.get()
}

group = "dev.nixgeek.passphrases"
version = "0.0.1"

//logger.lifecycle("> Using JDK toolchain version: ${java.toolchain.languageVersion.get()}")
//logger.lifecycle("> Using Kotlin version: ${extensions.findByType<KotlinTopLevelExtension>()?.coreLibrariesVersion}")

repositories {
    gradlePluginPortal()
    mavenCentral()
}

