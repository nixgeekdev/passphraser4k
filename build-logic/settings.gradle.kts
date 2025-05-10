import org.gradle.api.internal.FeaturePreviews

rootProject.name = "build-logic"

enableFeaturePreview(FeaturePreviews.Feature.TYPESAFE_PROJECT_ACCESSORS.name)

dependencyResolutionManagement {
    versionCatalogs {
        create("buildLibs") {
            from(files("../gradle/buildlibs.versions.toml"))
        }
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

include("build-conventions")
