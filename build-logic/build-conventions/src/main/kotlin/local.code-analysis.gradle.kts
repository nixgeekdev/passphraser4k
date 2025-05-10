import com.diffplug.spotless.LineEnding
import gradle.kotlin.dsl.accessors._ffcf889acdea48f400c29ebf21a196f7.build
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

plugins {
    id("io.gitlab.arturbosch.detekt")
    id("com.diffplug.spotless")
}

val kotlinVersion = provider { plugins.getPlugin(KotlinPluginWrapper::class.java).pluginVersion }

// Detekt
detekt {
    buildUponDefaultConfig = true
    allRules = false
    parallel = true
    config.from(files("${rootDir.path}/detekt.yml"))
    source.from(files("src/main/kotlin", "src/test/kotlin"))
}

tasks {
    withType<Detekt> {
        configureEach {
            jvmTarget = "21"
            reports {
                xml.required.set(false)
                html.required.set(true)
                txt.required.set(false)
                sarif.required.set(false)
                md.required.set(true)
            }
        }
    }
    withType<DetektCreateBaselineTask> {
        configureEach {
            jvmTarget = "21"
        }
    }
}

// Align kotlin version with the version used in the kotlin jvm plugin,
// except for detekt since it requires a specific kotlin version
configurations.matching { it.name != "detekt" }.configureEach {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.kotlin") {
            useVersion(kotlinVersion.get())
        }
    }
}

// Spotless
spotless {
    val disabledRules = mapOf(
        "ktlint_standard_annotation" to "disabled",
        "ktlint_standard_filename" to "disabled",
        "ktlint_standard_function-signature" to "disabled",
        "ktlint_standard_value-argument-comment" to "disabled",
        "ktlint_standard_value-parameter-comment" to "disabled",
    )

    lineEndings = LineEnding.PLATFORM_NATIVE

    kotlin {
        // ignore anything that is generated since those can't be fixed, e.g. protobuf files
        targetExclude("**/generated/**")

        // configure ktlint
        ktlint().editorConfigOverride(disabledRules)
    }

    kotlinGradle {
        // configure ktlint
        ktlint().editorConfigOverride(disabledRules)
    }
}

tasks {
    // Registers "lint" task runs "spotlessCheck"
    register("lint") {
        group = "verification"
        description = "Lint all code using configured linters. Runs 'spotlessCheck' "
        dependsOn(
            tasks.named("spotlessCheck"),
        )
    }
    // Registers "ktlint" task runs "spotlessKotlinCheck" and "spotlessKotlinGradleCheck"
    register("ktlint") {
        group = "verification"
        description = "Lint Kotlin code. Runs 'spotlessKotlinCheck' and 'spotlessKotlinGradleCheck'"
        dependsOn(
            tasks.named("spotlessKotlinCheck"),
            tasks.named("spotlessKotlinGradleCheck"),
        )
    }
    // Registers "format" task runs "spotlessApply"
    register("format") {
        group = "verification"
        description = "Format all code using configured formatters. Runs 'spotlessApply' "
        dependsOn(
            tasks.named("spotlessApply"),
        )
    }
    // Registers "ktformat" task runs "spotlessKotlinApply" and "spotlessKotlinGradleApply"
    register("ktformat") {
        group = "verification"
        description = "Format Kotlin code. Runs 'spotlessKotlinApply' and 'spotlessKotlinGradleApply'"
        dependsOn(
            tasks.named("spotlessKotlinApply"),
            tasks.named("spotlessKotlinGradleApply"),
        )
    }
    // Check Configurations
    check {
        dependsOn(tasks.named("detekt"))
    }
}
