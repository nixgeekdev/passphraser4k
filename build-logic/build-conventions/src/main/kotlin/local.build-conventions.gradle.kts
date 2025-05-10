import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("jvm")
}

// Inherit the group and version from the root project
group = rootProject.group
version = rootProject.version

val javaVersion = 21
val kotlinVersion = KotlinVersion.KOTLIN_2_1

configure<KotlinJvmProjectExtension> {
    jvmToolchain(javaVersion)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

sourceSets {
    main {
        java {
            srcDirs("$projectDir/src/main/kotlin/")
        }
    }
    test {
        java {
            srcDirs("$projectDir/src/test/kotlin/")
        }
    }
}

tasks {
    compileKotlin {
        compilerOptions {
            freeCompilerArgs.addAll("-Xjsr305=strict", "-opt-in=kotlin.RequiresOptIn")
            languageVersion.set(kotlinVersion)
            apiVersion.set(kotlinVersion)
            jvmTarget.set(JvmTarget.fromTarget(javaVersion.toString()))
        }
    }
    compileTestKotlin {
        compilerOptions {
            languageVersion.set(kotlinVersion)
            apiVersion.set(kotlinVersion)
            jvmTarget.set(JvmTarget.fromTarget(javaVersion.toString()))
        }
    }
    jar {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        from(sourceSets.main.get().output)
        dependsOn(configurations.runtimeClasspath)
        from({
            configurations.runtimeClasspath.get().map {
                if (it.isDirectory)
                    it
                else
                    zipTree(it)
            }
        })
        isPreserveFileTimestamps = false
        isReproducibleFileOrder = true
    }
}

configure<KotlinJvmProjectExtension> {
    jvmToolchain(javaVersion)
}

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
    resolutionStrategy.cacheDynamicVersionsFor(0, TimeUnit.SECONDS)
}

// Create JARs in a reproducible build fashion.
tasks.withType<AbstractArchiveTask>().configureEach {
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
}
