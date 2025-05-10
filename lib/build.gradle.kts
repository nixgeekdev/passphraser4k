
plugins {
    id("local.library-conventions")
}

dependencies {
    detektPlugins(libs.detekt.formatting)

    listOf(
        libs.kotlinx.serialization.json,
    ).forEach(::implementation)

    listOf(
        libs.kotest.assertions,
        libs.kotest.datatest,
        libs.kotest.runner,
    ).forEach(::testImplementation)
}
