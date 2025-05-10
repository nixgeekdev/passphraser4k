# passphraser4k

A library for working with Randomly-Generated Passphrases based on Wordlists. 

Weak passwords and passphrases are one of the most common flaws in computer
security. The passphrase generation methods implemented in this library offer a
better way to create a strong, yet easy to remember, passphrase for use with
encryption and security programs. This library provides an implementation of the
Diceware method of passphrase generation and others, and it uses Java Secure
Random to ensure dice rolls are random enough. Read more about it in the
[wiki][wiki].

----

## Toolchain

These tools are known to work. You can use others if you wish, but YMMV.

- Azul (zulu) JDK 21
- Kotlin 2.1.20 or newer
- Gradle 8.14 or newer
- IntelliJ 2025.1.1 or newer

## Build

To build the project, simply run: 

    ./gradlew build

The above command will also execute tests. To avoid tests, simply run:

    ./gradlew build -x test

And to ensure all build tasks are executed, you may run:

    ./gradlew build --rerun-tasks

## Development Standards

Please read the [contributions][contributing] document. We stick to a few simple rules to keep 
this codebase in good shape.

1. Formatting and linting is handled by [detekt][detekt]. Builds will 
   fail if your code does not pass these checks.
    1. To lint your code: `./gradlew check`
2. Test your code.
    1. code should almost always have unit tests.
    2. we use the [kotest][kotest] framework to implement our tests
3. Document your code.
    1. Try to imagine what a new developer with no context will need to know about your code. If 
       it's not obvious, document it.
    2. Include links to reference materials you use.
    3. Use [KDoc][kdoc] syntax.

## License

This library is licensed under the Apache License Version 2.0 - Please read the [licensing](LICENSE) 
document for more details.

## Code of Conduct

Please read our [Code of Conduct][coc] document.

## Security

Please read our [Security Policy][secpol] document.

## Changelog

A detailed record of changes between versions is kept under the [releases][releases] page.

[wiki]:https://github.com/nixgeekdev/passphraser4k/wiki
[contributing]:https://github.com/nixgeekdev/.github/blob/main/CONTRIBUTING.md
[detekt]:https://github.com/detekt/detekt
[kotest]:https://kotest.io/
[kdoc]:https://kotlinlang.org/docs/kotlin-doc.html#kdoc-syntax
[coc]:https://github.com/nixgeekdev/.github/blob/main/CODE_OF_CONDUCT.md
[secpol]:https://github.com/nixgeekdev/.github/blob/main/SECURITY.md
[releases]:https://github.com/nixgeekdev/passphraser4k/releases
