plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    listOf(
        // buildLibs.build.jackson.core,
        buildLibs.build.kotlin.jvm,
        buildLibs.build.kotlin.api,
        buildLibs.build.kover,
    ).forEach {
        implementation(it)
    }

    listOf(
        buildLibs.build.detekt,
        buildLibs.build.spotless,
        buildLibs.build.dependency.analysis,
        buildLibs.build.owasp.dependencycheck,
        buildLibs.build.versions,
        buildLibs.build.tasktree,
        buildLibs.build.testlogger,
    ).forEach {
        api(it)
    }
}
