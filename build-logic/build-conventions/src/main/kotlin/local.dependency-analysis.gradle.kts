import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.autonomousapps.dependency-analysis")
    id("com.github.ben-manes.versions")
    id("org.owasp.dependencycheck")
}

// https://github.com/ben-manes/gradle-versions-plugin/discussions/482
// https://app.shortcut.com/figure/story/113449/identifying-outdated-dependencies-inter-repository
tasks {
    named<DependencyUpdatesTask>("dependencyUpdates").configure {
        revision = "release"
        // reject all non stable versions
        rejectVersionIf {
            isNonStable(candidate.version)
        }
        // disallow release candidates as upgradable versions from stable versions
        rejectVersionIf {
            isStable(currentVersion) && isNonStable(candidate.version)
        }
    }
}

dependencyCheck {
    failOnError = true
    format = "HTML"
    analyzers {
        retirejs { enabled = false }
        ossIndex { enabled = false }
        assemblyEnabled = false
        msbuildEnabled = false
        nodeEnabled = false
        nodeAuditEnabled = false
        nugetconfEnabled = false
        nuspecEnabled = false
        opensslEnabled = false
        experimentalEnabled = false

        jarEnabled = true
        archiveEnabled = true
    }
    nvd {
        apiKey = System.getenv("NVD_API_KEY")
    }
}

fun isNonStable(version: String): Boolean {
    val containsStableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val simpleSemverRegex = "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)".toRegex()
    val isStable = containsStableKeyword || simpleSemverRegex.matches(version)
            && !listOf("alpha", "beta", "rc").any { version.lowercase().contains(it) } && !version.contains("M")
    return isStable.not()
}

fun isStable(version: String): Boolean = !isNonStable(version)
